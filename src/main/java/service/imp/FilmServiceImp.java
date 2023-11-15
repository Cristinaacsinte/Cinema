package service.imp;

import euris.academy.Cinema.Entity.Film;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.FilmRepository;
import service.FilmService;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmServiceImp implements FilmService {
    FilmRepository filmRepository;
    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film insert(Film film) {
        if(film.getId() != null && film.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return filmRepository.save(film);
    }

    @Override
    public Film update(Film film) {
        if(film.getId() == null || film.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return filmRepository.save(film);
    }

    @Override
    public Boolean deleteById(Integer idFilm) {
        filmRepository.deleteById(idFilm);
        return filmRepository.findById(idFilm).isEmpty();
    }

    @Override
    public Film findById(Integer idFilm) {
        return filmRepository.findById(idFilm).orElse(Film.builder().build());
    }
}
