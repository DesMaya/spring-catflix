package estudos.maya.CatFlix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatFlixApplication implements CommandLineRunner {
	public static void main(String[] args){
		SpringApplication.run(CatFlixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, World!");
		System.out.println("Primeiro projeto Spring sem Web");
	}
}
