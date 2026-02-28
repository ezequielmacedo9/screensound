package br.com.ezequiel.screensound.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosArtistaApi(
        String strArtist,
        String strGenre,
        String strBiographyPT,
        String strCountry
) {}