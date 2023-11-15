package service;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();

    Film insert(Film film);

    Film update(Film film);

    Boolean deleteById(Integer idFilm);

    Film findById(Integer idFilm);
}
