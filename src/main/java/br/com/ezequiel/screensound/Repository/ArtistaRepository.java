package br.com.ezequiel.screensound.Repository;

import br.com.ezequiel.screensound.Model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository <Artista, Long>{
    Optional<Artista> findByNomeIgnoreCase(String nomeArtista);

}
