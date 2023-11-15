package euris.academy.Cinema.Entity;

import euris.academy.Cinema.DTO.SpettatoreDTO;
import euris.academy.Cinema.Entity.archetype.Dto;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spettatore")
public class Spettatore implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name" )
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birthe")
    private LocalDate dateOfBirthe;

    @OneToMany
    @JoinColumn(name = "id_biglietto")
    private List<Biglietto>biglietto;
    public int ageOfSpettatore(Spettatore spettatore){
        return Period.between(LocalDate.now(),spettatore.getDateOfBirthe()).getYears();
    }
    public boolean isAnAdult(Spettatore spettatore){
        if(ageOfSpettatore(spettatore)>=18){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SpettatoreDTO toDto() {
        return SpettatoreDTO
                .builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .biglietto(biglietto)
                .dateOfBirthe(dateOfBirthe)
                .build();
    }
}
