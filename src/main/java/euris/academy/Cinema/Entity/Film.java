package euris.academy.Cinema.Entity;

import euris.academy.Cinema.DTO.FilmDTO;
import euris.academy.Cinema.Entity.archetype.Dto;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film")
public class Film implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "production")
    private String production;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private int duration;

    @Column(name = "minimum_age")
    private int minimumAge;


    @OneToOne
    @JoinColumn(name = "id_sala_cinema")
    private SalaCinema salaCinema;

    @Override
    public FilmDTO toDto() {
        return FilmDTO
                .builder()
                .id(id)
                .author(author)
                .duration(duration)
                .genre(genre)
                .minimumAge(minimumAge)
                .production(production)
                .salaCinema(salaCinema)
                .title(title)
                .build();
    }
}
