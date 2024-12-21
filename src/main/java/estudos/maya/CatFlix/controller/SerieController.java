package estudos.maya.CatFlix.controller;

import estudos.maya.CatFlix.dto.SerieDTO;
import estudos.maya.CatFlix.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

@Autowired
private SerieService servico;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries(){
        return servico.obterTodasAsSeries();
    }

}
