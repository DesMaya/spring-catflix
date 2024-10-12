package estudos.maya.CatFlix;

import estudos.maya.CatFlix.service.ConsumoApi;
import estudos.maya.model.DadosSerie;
import estudos.maya.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//https://www.omdbapi.com/?t=matrix&apikey=a10bdbc
@SpringBootApplication
public class CatFlixApplication implements CommandLineRunner {
	public static void main(String[] args){
		SpringApplication.run(CatFlixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var conversor = new ConverteDados();

		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&apikey=a10bdbc");
		var dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
