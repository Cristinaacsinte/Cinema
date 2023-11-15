package euris.academy.Cinema.service.imp;

import euris.academy.Cinema.Entity.Spettatore;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import euris.academy.Cinema.service.SpettatoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import euris.academy.Cinema.repository.SpettatoreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SpettatoreServiceImp implements SpettatoreService {
    SpettatoreRepository spettatoreRepository;
    @Override
    public List<Spettatore> findAll() {
        return spettatoreRepository.findAll();
    }

    @Override
    public Spettatore insert(Spettatore spettatore) {
        if(spettatore.getId() != null && spettatore.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return spettatoreRepository.save(spettatore);
    }

    @Override
    public Spettatore update(Spettatore spettatore) {
        if(spettatore.getId() == null || spettatore.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return spettatoreRepository.save(spettatore);
    }
    @Override
    public Boolean deleteById(Integer idSpettatore) {
        spettatoreRepository.deleteById(idSpettatore);
        return spettatoreRepository.findById(idSpettatore).isEmpty();
    }

    @Override
    public Spettatore findById(Integer idSpettatore) {
        return spettatoreRepository.findById(idSpettatore).orElse(Spettatore.builder().build());
    }

}
