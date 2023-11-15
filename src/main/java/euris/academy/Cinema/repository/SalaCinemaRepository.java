package euris.academy.Cinema.repository;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.SalaCinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaCinemaRepository extends JpaRepository<SalaCinema, Integer> {
}
