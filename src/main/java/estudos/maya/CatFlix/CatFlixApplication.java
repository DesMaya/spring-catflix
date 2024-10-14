package estudos.maya.CatFlix;

import estudos.maya.CatFlix.principal.Principal;
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
		/*
		var consumoApi = new ConsumoApi();
		var conversor = new ConverteDados();

		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&apikey=a10bdbc");
		var dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);

		json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&Season=4&Episode=8&apikey=a10bdbc");
		var dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dadosSerie.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&Season=" + i + "&apikey=a10bdbc");
			temporadas.add(conversor.obterDados(json, DadosTemporada.class));
		}

		temporadas.forEach(System.out::println);
		*/
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
