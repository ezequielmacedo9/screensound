package br.com.ezequiel.screensound.Service;

import br.com.ezequiel.screensound.Service.IConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConverteDados implements IConverteDados {
    public ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classes) {
        try {
            return mapper.readValue(json, classes);
        } catch (JsonProcessingException e) {
            throw
                    new RuntimeException("Erro ao converter JSON", e);
        }
    }
}
