package estudos.maya.CatFlix.service;

import estudos.maya.CatFlix.dto.SerieDTO;
import estudos.maya.CatFlix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> obterTodasAsSeries() {
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
