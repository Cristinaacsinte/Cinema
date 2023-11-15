package euris.academy.Cinema.DTO;

import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.Entity.SalaCinema;
import euris.academy.Cinema.Entity.Spettatore;
import euris.academy.Cinema.Entity.archetype.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BigliettoDTO implements Dto {

    private Integer id;

    private Integer position;

    private SalaCinema salaCinema;

    private Spettatore spettatore;
    @Override
    public Biglietto toModel() {

        return Biglietto
                .builder()
                .id(id)
                .position(position)
                .salaCinema(salaCinema)
                .spettatore(spettatore)
                .build();
    }
}
