package euris.academy.Cinema.Entity;

import euris.academy.Cinema.DTO.BigliettoDTO;
import euris.academy.Cinema.Entity.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "biglietto")
public class Biglietto implements Model {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position")
    private Integer position;

    @Column(name = "price")
    private long price;

    @ManyToOne
    @JoinColumn(name = "id_sala_cinema")
    private SalaCinema salaCinema;


    @ManyToOne
    @MapsId("spettatoreId")
    @JoinColumn(name = "spettatore_id")
    private Spettatore spettatore;


    @Override
    public BigliettoDTO toDto() {
        return BigliettoDTO
                .builder()
                .id(id)
                .position(position)
                .salaCinema(salaCinema)
                .spettatore(spettatore)
                .build();
    }
}
