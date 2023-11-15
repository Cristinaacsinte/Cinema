package service.imp;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.Spettatore;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.BigliettoRepository;
import service.BigliettoService;

import java.util.List;

@Service
@AllArgsConstructor
public class BigliettoServiceImp implements BigliettoService {
    BigliettoRepository bigliettoRepository;
    @Override
    public List<Biglietto> findAll() {
        return bigliettoRepository.findAll();
    }

    @Override
    public Biglietto insert(Biglietto biglietto) {
        if(biglietto.getId() != null && biglietto.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return bigliettoRepository.save(biglietto);
    }

    @Override
    public Biglietto update(Biglietto biglietto) {
        if(biglietto.getId() == null || biglietto.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return bigliettoRepository.save(biglietto);
    }

    @Override
    public Boolean deleteById(Integer idBiglietto) {
        bigliettoRepository.deleteById(idBiglietto);
        return bigliettoRepository.findById(idBiglietto).isEmpty();
    }

    @Override
    public Biglietto findById(Integer idBiglietto) {
        return bigliettoRepository.findById(idBiglietto).orElse(Biglietto.builder().build());
    }
    public void discountTicket(Spettatore spettatore,Biglietto biglietto){
        if (spettatore.ageOfSpettatore(spettatore)<=5){
            biglietto.setPrice(biglietto.getPrice()/2L);

        } else if (spettatore.ageOfSpettatore(spettatore)>=70) {
            biglietto.setPrice((90L* biglietto.getPrice())/100L);

        }
    }
}
