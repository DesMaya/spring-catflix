package estudos.maya.CatFlix.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Serie {
    private String titulo;
    private Categoria genero;
    private Integer totalTemporadas;
    private Double avaliacao;
    private String atores;
    private String sinopse;
    private String poster;
}
