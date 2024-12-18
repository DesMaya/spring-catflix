package estudos.maya.CatFlix.dto;

import estudos.maya.CatFlix.model.Categoria;
import jakarta.persistence.*;

public record SerieDTO (
     Long id,
     String titulo,
     Categoria genero,
     Integer totalTemporadas,
     Double avaliacao,
     String atores,
     String sinopse,
     String poster
    ){
}
