package estudos.maya.CatFlix.controller;

import estudos.maya.CatFlix.dto.SerieDTO;
import estudos.maya.CatFlix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository repository;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries(){
        return repository.findAll().stream()
                .map(s -> new SerieDTO(
                        s.getId(),
                        s.getTitulo(),
                        s.getGenero(),
                        s.getTotalTemporadas(),
                        s.getAvaliacao(),
                        s.getAtores(),
                        s.getSinopse(),
                        s.getPoster()))
                .collect(Collectors.toList());
    }

}
/*
    Long id,
     String titulo,
     Categoria genero,
     Integer totalTemporadas,
     Double avaliacao,
     String atores,
     String sinopse,
     String poster
 */