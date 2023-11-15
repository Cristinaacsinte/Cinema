package service;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.SalaCinema;

import java.util.List;

public interface SalaCinemaService {
    List<SalaCinema> findAll();

    SalaCinema insert(SalaCinema salaCinema);

    SalaCinema update(SalaCinema salaCinema);

    Boolean deleteById(Integer idSalaCinema);

    SalaCinema findById(Integer idSalaCinema);
}
