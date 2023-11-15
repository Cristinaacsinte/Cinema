package repository;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
