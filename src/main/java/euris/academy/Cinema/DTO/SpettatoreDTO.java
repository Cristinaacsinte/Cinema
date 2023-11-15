package euris.academy.Cinema.DTO;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.Spettatore;
import euris.academy.Cinema.Entity.archetype.Dto;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpettatoreDTO implements Dto {

    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirthe;

    private List<Biglietto> biglietto;
    @Override
    public Spettatore toModel() {

        return Spettatore
                .builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirthe(dateOfBirthe)
                .biglietto(biglietto)
                .build();
    }
}
