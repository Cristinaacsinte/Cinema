package euris.academy.Cinema.repository;

import euris.academy.Cinema.Entity.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BigliettoRepository extends JpaRepository<Biglietto, Integer> {
}
