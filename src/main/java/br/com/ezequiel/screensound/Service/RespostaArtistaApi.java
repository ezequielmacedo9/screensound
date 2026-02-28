package br.com.ezequiel.screensound.Service;

import java.util.List;

public record RespostaArtistaApi(List<DadosArtistaApi> artists) {

    public List<DadosArtistaApi> getArtists() {
        return artists;
    }

}
