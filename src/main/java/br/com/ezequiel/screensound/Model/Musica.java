package br.com.ezequiel.screensound.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table( name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    private LocalDate dataLancamento;

    public Musica(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  " Musicas : " +
                " ID : " + id +
                " Titulo : " + nome +
                " Nome : " + artista +
                " Data de Lançamento : " + dataLancamento;
    }
}
