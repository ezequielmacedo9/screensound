package br.com.ezequiel.screensound.Service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classes);
}