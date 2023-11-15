package service;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.Spettatore;

import java.util.List;

public interface SpettatoreService {
    List<Spettatore> findAll();

    Spettatore insert(Spettatore spettatore);

    Spettatore update(Spettatore spettatore);

    Boolean deleteById(Integer idSpettatore);

    Spettatore findById(Integer idSpettatore);
}
