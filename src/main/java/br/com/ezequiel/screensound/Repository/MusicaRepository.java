package br.com.ezequiel.screensound.Repository;

import br.com.ezequiel.screensound.Model.Musica;
import br.com.ezequiel.screensound.Model.TipoArtista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository <Musica, Long> {

    List<Musica> findByArtistaNomeContainingIgnoreCase(String artista);
}
