package estudos.maya.CatFlix.principal;

import estudos.maya.CatFlix.model.DadosSerie;
import estudos.maya.CatFlix.model.DadosTemporada;
import estudos.maya.CatFlix.model.Episodio;
import estudos.maya.CatFlix.service.ConsumoApi;
import estudos.maya.CatFlix.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Principal {
    private final Scanner sc = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a10bdbc";

    public void exibeMenu() {
        System.out.println("Digite o nome da série que deseja buscar: ");
        var nomeSerie = sc.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        var dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++){
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i +  API_KEY);
            var dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());
        //episodios.forEach(System.out::println);


//        System.out.println("\nOs 5 melhores episódios da série " + dadosSerie.titulo());
//        episodios.stream()
//                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
//                .limit(5)
//                .forEach(System.out::println);


//        System.out.println("\nA partir de qual ano você deseja ver os episódios? ");
//        var ano = sc.nextInt();
//        sc.nextLine();
//
//        var dataBusca = LocalDate.of(ano, 1, 1);
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> {
//                    System.out.println(
//                            "Temporada: " + e.getTemporada() + " " +
//                            "Episodio: " + e.getTitulo() + " " +
//                            "Ano de lançamento: " + e.getDataLancamento().format(formatador)
//                    );
//                });

//        System.out.println("\nDigite um trecho de título que deseja buscar: ");
//        var trechoTitulo = sc.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//                .findFirst();
//
//        if (episodioBuscado.isPresent()) {
//            System.out.println("Episódio encontrado!");
//            System.out.printf("Temporada: %s Episódio: %s", episodioBuscado.get().getTemporada(), episodioBuscado.get().getTitulo());
//        } else System.out.println("Episodio não encontrado");

        Map<Integer, Double> avaliacoesTemporada = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));

        System.out.println(avaliacoesTemporada);


        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        System.out.printf("""
        Média: %.2f
        Melhor episódio: %.2f
        Pior episódio: %.2f
        Quantidade %d
        """, est.getAverage(), est.getMax(), est.getMin(), est.getCount());
    }
}
