package euris.academy.Cinema.controller;

import euris.academy.Cinema.DTO.FilmDTO;
import euris.academy.Cinema.Entity.Film;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import euris.academy.Cinema.service.FilmService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/film")
public class FilmController {
    FilmService filmService;
    @GetMapping("/v1")
    public List<FilmDTO> getAllFilm() {
        return filmService.findAll().stream().map(Film::toDto).toList();
    }

    @PostMapping("/v1")
    public FilmDTO saveFilm(@RequestBody FilmDTO filmDTO) {
        try{
            Film film = filmDTO.toModel();
            return filmService.insert(film).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public FilmDTO updateFilm(@RequestBody FilmDTO filmDTO){
        try{
            Film film = filmDTO.toModel();
            return filmService.update(film).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteFilm(@PathVariable("id") Integer idFilm) {
        return filmService.deleteById(idFilm);
    }

    @GetMapping("/v1/{id}")
    public FilmDTO getBigliettoById(@PathVariable("id") Integer idFilm) {
        return filmService.findById(idFilm).toDto();
    }
}
