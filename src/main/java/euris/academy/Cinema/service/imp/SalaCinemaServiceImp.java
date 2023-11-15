package euris.academy.Cinema.service.imp;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.SalaCinema;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import euris.academy.Cinema.service.SalaCinemaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import euris.academy.Cinema.repository.SalaCinemaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalaCinemaServiceImp implements SalaCinemaService {
    SalaCinemaRepository salaCinemaRepository;
    @Override
    public List<SalaCinema> findAll() {
        return salaCinemaRepository.findAll();
    }

    @Override
    public SalaCinema insert(SalaCinema salaCinema) {
        if(salaCinema.getId() != null && salaCinema.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return salaCinemaRepository.save(salaCinema);
    }

    @Override
    public SalaCinema update(SalaCinema salaCinema) {
        if(salaCinema.getId() == null || salaCinema.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return salaCinemaRepository.save(salaCinema);
    }

    @Override
    public Boolean deleteById(Integer idSalaCinema) {
        salaCinemaRepository.deleteById(idSalaCinema);
        return salaCinemaRepository.findById(idSalaCinema).isEmpty();
    }

    @Override
    public SalaCinema findById(Integer idSalaCinema) {
        return salaCinemaRepository.findById(idSalaCinema).orElse(SalaCinema.builder().build());
    }
    public SalaCinema svuotaSala(SalaCinema salaCinema){
        if(salaCinema.getBiglietto().isEmpty()){
            return salaCinema;
        }else {
          List<Biglietto> postiVenduti= new ArrayList<>();
            salaCinema.setBiglietto(postiVenduti);
            return salaCinema;
        }
    }

    public Optional<Long> incassoSala(SalaCinema salaCinema){
        List<Long> price= new ArrayList<>();
        salaCinema.
                getBiglietto()
                .stream()
                .forEach(biglietto -> {
                    price.add(biglietto.getPrice());
                });
        return price.stream().reduce(Long::sum);
    }
}
