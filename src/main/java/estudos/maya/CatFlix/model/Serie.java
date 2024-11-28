package estudos.maya.CatFlix.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Categoria genero;
    private Integer totalTemporadas;
    private Double avaliacao;
    private String atores;
    private String sinopse;
    private String poster;

    public Serie (DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0.0);
        this.genero = Categoria.valueOf(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.sinopse = dadosSerie.sinopse();
        this.poster = dadosSerie.poster();
    }
}
