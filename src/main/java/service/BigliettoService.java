package service;

import euris.academy.Cinema.Entity.Biglietto;

import java.util.List;

public interface BigliettoService {
    List<Biglietto> findAll();

    Biglietto insert(Biglietto biglietto);

    Biglietto update(Biglietto biglietto);

    Boolean deleteById(Integer idBiglietto);

    Biglietto findById(Integer idBiglietto);
}
