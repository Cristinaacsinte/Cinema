package euris.academy.Cinema.Entity;

import euris.academy.Cinema.DTO.SalaCinemaDTO;
import euris.academy.Cinema.Entity.archetype.Dto;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sala")
public class SalaCinema implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "max_biglietti")
    private Integer maxBiglietti;


    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Biglietto> biglietto;


    @Override
    public SalaCinemaDTO toDto() {
        return SalaCinemaDTO
                .builder()
                .id(id)
                .maxBiglietti(maxBiglietti)
                .film(film)
                .biglietto(biglietto)
                .build();
    }
}
