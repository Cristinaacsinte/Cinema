package euris.academy.Cinema.DTO;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.Film;
import euris.academy.Cinema.Entity.SalaCinema;
import euris.academy.Cinema.Entity.archetype.Dto;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaCinemaDTO implements Dto {

    private Integer id;

    private Integer maxBiglietti;

    private Film film;

    private List<Biglietto> biglietto;
    @Override
    public SalaCinema toModel() {

        return SalaCinema
                .builder()
                .id(id)
                .maxBiglietti(maxBiglietti)
                .biglietto(biglietto)
                .film(film)
                .build();
    }
}
