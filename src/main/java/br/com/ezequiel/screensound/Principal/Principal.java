package br.com.ezequiel.screensound.Principal;

import br.com.ezequiel.screensound.Model.Artista;
import br.com.ezequiel.screensound.Model.Musica;
import br.com.ezequiel.screensound.Model.TipoArtista;
import br.com.ezequiel.screensound.Repository.ArtistaRepository;
import br.com.ezequiel.screensound.Repository.MusicaRepository;
import br.com.ezequiel.screensound.Service.ConsumoApi;
import br.com.ezequiel.screensound.Service.ConverteDados;
import br.com.ezequiel.screensound.Service.RespostaArtistaApi;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private static final String ENDERECO =
            "https://www.theaudiodb.com/api/v1/json/2/";

    private MusicaRepository musicaRepository;

    private ArtistaRepository repository;

    public Principal(ArtistaRepository repository,
                     MusicaRepository musicaRepository) {
        this.repository = repository;
        this.musicaRepository = musicaRepository;
    }
    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 9) {
            var menu = """
                 Screen Sound Músicas
                ------------------------
                1 - Cadastrar Artista
                2 - Cadastrar Música
                3 - Listar Músicas
                4 - Buscar Músicas por Artista
                5 - Pesquisar sobre o Artista
              
                9 - Sair
                ------------------------
                Digite sua opção:
                """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisaSobreArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }
    }


    private void cadastrarArtista() {
        String continuar;
        do {
            // 1. Pergunta nome do artista
            System.out.println("Digite o nome do artista: ");
            var nomeArtista = leitura.nextLine();

            // 2. Pergunta tipo do artista
            System.out.println("Qual tipo do Artista? (SOLO / BANDA / DUPLA)");
            var tipoString = leitura.nextLine();

            // 3. Converte para Enum
            TipoArtista tipoEnum;
            try {
                tipoEnum = TipoArtista.valueOf(tipoString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo inválido! Usando SOLO como padrão.");
                tipoEnum = TipoArtista.SOLO;
            }

            // 4. Cria objeto Artista
            Artista novoArtista = new Artista();
            novoArtista.setNome(nomeArtista);
            novoArtista.setTipoArtista(tipoEnum);

            Optional<Artista> existente = repository.findByNomeIgnoreCase(nomeArtista);
            if (existente.isPresent()) {
                System.out.println("Artista já cadastrado!");
                return;
            }

            // 5. Salva no banco
            repository.save(novoArtista);

            // 6. Confirmação
            System.out.println("Artista cadastrado com sucesso: " + novoArtista);

            // 7. Pergunta se quer cadastrar outro
            System.out.println("Deseja cadastrar outro artista? (S/N)");
            continuar = leitura.nextLine().trim().toUpperCase();
        } while (continuar.equals("S"));
    }


    private void cadastrarMusica() {
        String continuar = "S";

        do {
            System.out.println("Digite o nome da música:");
            String nomeMusica = leitura.nextLine();

            System.out.println("Digite o nome do artista:");
            String nomeArtista = leitura.nextLine();

            Optional<Artista> artistaOptional =
                    repository.findByNomeIgnoreCase(nomeArtista);

            if (artistaOptional.isEmpty()) {
                System.out.println("Artista não encontrado. Cadastre o artista primeiro.");
                continue;
            }

            System.out.println("Digite a data de lançamento (yyyy-MM-dd): ");
            String dataTexto = leitura.nextLine();

            LocalDate dataLancamento = LocalDate.parse(dataTexto);

            Musica musica = new Musica();
            musica.setNome(nomeMusica);
            musica.setArtista(artistaOptional.get());
            musica.setDataLancamento(dataLancamento);

            musicaRepository.save(musica);

            System.out.println("Música cadastrada com sucesso!");

            System.out.println("Deseja cadastrar outra música? (S/N)");
            continuar = leitura.nextLine().trim().toUpperCase();

        } while (continuar.equals("S"));
    }

    private void listarMusicas() {

        // 1. Buscar músicas no banco
        List<Musica> musicasListadas = musicaRepository.findAll();

        // 2. Verificar se está vazia
        if (musicasListadas.isEmpty()) {
            System.out.println("Lista de Músicas vazia.");
        } else {

            // 3. Percorrer lista
            musicasListadas.forEach(m ->
                    System.out.println("Nome: " + m.getNome()
                            + " | Artista: " + m.getArtista().getNome()
                            + " | Data de Lançamento: " + m.getDataLancamento())
            );
        }
    }
    private void buscarMusicaPorArtista() {
        String continuar = "S";
        do {
            // 1. Pergunta o nome do artista
            System.out.println("Digite o nome do Artísta: ");
            var nomeCantor = leitura.nextLine();

            // 2. Busca o artista no banco
            Optional<Artista> cantor = repository.findByNomeIgnoreCase(nomeCantor);

            // 3. Verifica se o artista foi encontrado
            if (cantor.isEmpty()) {
                System.out.println("Artísta não encontrado.");
                continue;
            }

            // 4. Acessa a lista de músicas do artista
            List<Musica> musicasDoCantor = cantor.get().getMusicas();

            // 5. Verifica se o artista tem músicas cadastradas
            if (musicasDoCantor.isEmpty()) {
                System.out.println("Nenhuma música cadastradas desse artísta.");
                continue;
            }

            // 6. Percorre a lista de músicas
            for (Musica musica : musicasDoCantor) {


                // 7. Exibe todas as músicas do artista na tela
                System.out.println(musica.getNome());
            }
            System.out.println("Deseja listar novamente? (S/N)");
            continuar = leitura.nextLine().trim().toUpperCase();

        } while (continuar.equals("S"));
    }

    private void pesquisaSobreArtista() {
        System.out.println("Digite o nome do Artísta: ");
        var nomeArtista = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + "search.php?s=" + nomeArtista.replace(" ", "+"));
        var resposta = conversor.obterDados(json, RespostaArtistaApi.class);

        if (resposta.artists() == null) {
            System.out.println("Artista não encontrado!");
            return;
        }

        var artista = resposta.artists().get(0);

        System.out.println("""
                            Nome: %s
                            Gênero: %s
                            País: %s
                            Biografia: %s
                            """.formatted(
                                artista.strArtist(),
                                artista.strGenre(),
                                artista.strCountry(),
                                artista.strBiographyPT()
        ));

    }


}
