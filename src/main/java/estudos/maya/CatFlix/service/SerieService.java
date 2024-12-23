package estudos.maya.CatFlix.service;

import estudos.maya.CatFlix.dto.EpisodioDTO;
import estudos.maya.CatFlix.dto.SerieDTO;
import estudos.maya.CatFlix.model.Serie;
import estudos.maya.CatFlix.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    private List<SerieDTO> converteDados (List<Serie> series){
        return series.stream()
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

    public List<SerieDTO> obterTodasAsSeries() {
        return converteDados(repository.findAll());
    }

    public List<SerieDTO> obterTop5Series() {
        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDados(repository.encontrarEpisodiosMaisRecentes());
    }

    public SerieDTO obterPorId(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(
                    s.getId(),
                    s.getTitulo(),
                    s.getGenero(),
                    s.getTotalTemporadas(),
                    s.getAvaliacao(),
                    s.getAtores(),
                    s.getSinopse(),
                    s.getPoster());
        } else return null;
    }

    public List<EpisodioDTO> obterTodasTemporadas(Long id) {
        Optional<Serie> serie = repository.findById(id);

        if (serie.isPresent()) {
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDTO(
                            e.getTemporada(),
                            e.getNumeroEpisodio(),
                            e.getTitulo()
                    ))
                    .collect(Collectors.toList());
        } return null;
    }

    public List<EpisodioDTO> obterTemporadasPorNumero(Long id, Integer numero) {
        return repository.obterEpisodiosPorTemporada(id, numero)
                .stream()
                .map(e -> new EpisodioDTO(
                        e.getTemporada(),
                        e.getNumeroEpisodio(),
                        e.getTitulo()
                ))
                .collect(Collectors.toList());
    }
}
