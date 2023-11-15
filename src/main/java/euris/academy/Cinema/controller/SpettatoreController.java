package euris.academy.Cinema.controller;

import euris.academy.Cinema.DTO.SpettatoreDTO;
import euris.academy.Cinema.Entity.Spettatore;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import euris.academy.Cinema.service.SpettatoreService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/spettatore")
public class SpettatoreController {
    SpettatoreService spettatoreService;
    @GetMapping("/v1")
    public List<SpettatoreDTO> getAllSpettatore() {
        return spettatoreService.findAll().stream().map(Spettatore::toDto).toList();
    }

    @PostMapping("/v1")
    public SpettatoreDTO saveSpettatore(@RequestBody SpettatoreDTO spettatoreDTO) {
        try{
            Spettatore spettatore = spettatoreDTO.toModel();
            return spettatoreService.insert(spettatore).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public SpettatoreDTO updateSpettatore(@RequestBody SpettatoreDTO spettatoreDTO){
        try{
           Spettatore spettatore= spettatoreDTO.toModel();
            return spettatoreService.update(spettatore).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteSpettatore(@PathVariable("id") Integer idSpettatore) {
        return spettatoreService.deleteById(idSpettatore);
    }

    @GetMapping("/v1/{id}")
    public SpettatoreDTO getSalaCinemaById(@PathVariable("id") Integer idSpettatore) {
        return spettatoreService.findById(idSpettatore).toDto();
    }
}
