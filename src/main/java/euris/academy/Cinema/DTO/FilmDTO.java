package euris.academy.Cinema.DTO;

import euris.academy.Cinema.Entity.Film;
import euris.academy.Cinema.Entity.SalaCinema;
import euris.academy.Cinema.Entity.archetype.Dto;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDTO implements Dto {

    private Integer id;

    private String title;

    private String author;

    private String production;

    private String genre;

    private int duration;

    private int minimumAge;
    private SalaCinema salaCinema;
    @Override
    public Film toModel() {

        return Film
                .builder()
                .id(id)
                .author(author)
                .genre(genre)
                .duration(duration)
                .minimumAge(minimumAge)
                .title(title)
                .production(production)
                .salaCinema(salaCinema)
                .build();
    }
}
