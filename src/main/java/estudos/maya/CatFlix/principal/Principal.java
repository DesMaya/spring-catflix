package estudos.maya.CatFlix.principal;

import estudos.maya.CatFlix.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private final Scanner sc = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a10bdbc";

    public void exibeMenu() {
        System.out.println("Digite o nome da série que deseja buscar: ");
        var nomeSerie = sc.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        System.out.println(json);

    }
}
