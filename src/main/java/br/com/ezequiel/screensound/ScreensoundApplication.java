package br.com.ezequiel.screensound;

import br.com.ezequiel.screensound.Principal.Principal;
import br.com.ezequiel.screensound.Repository.ArtistaRepository;
import br.com.ezequiel.screensound.Repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

    @Autowired
    private ArtistaRepository repository;

    @Autowired
    private MusicaRepository musicaRepository;

	public static void main(String[] args){
		SpringApplication.run(ScreensoundApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repository, musicaRepository);
        principal.exibeMenu();
    }
}
