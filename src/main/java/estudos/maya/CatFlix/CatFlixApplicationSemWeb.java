package estudos.maya.CatFlix;

import estudos.maya.CatFlix.principal.Principal;
import estudos.maya.CatFlix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatFlixApplicationSemWeb implements CommandLineRunner {

	@Autowired
	private SerieRepository repositorio;

	public static void main(String[] args){
		SpringApplication.run(CatFlixApplicationSemWeb.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
