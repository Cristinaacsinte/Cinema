package euris.academy.Cinema.controller;

import euris.academy.Cinema.DTO.BigliettoDTO;
import euris.academy.Cinema.Entity.Biglietto;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.BigliettoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/biglietto")
public class BigliettoController {
    BigliettoService bigliettoService;
    @GetMapping("/v1")
    public List<BigliettoDTO> getAllBiglietto() {
        return bigliettoService.findAll().stream().map(Biglietto::toDto).toList();
    }

    @PostMapping("/v1")
    public BigliettoDTO saveBiglietto(@RequestBody BigliettoDTO bigliettoDTO) {
        try{
            Biglietto biglietto = bigliettoDTO.toModel();
            return bigliettoService.insert(biglietto).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public BigliettoDTO updateBiglietto(@RequestBody BigliettoDTO bigliettoDTO){
        try{
            Biglietto biglietto = bigliettoDTO.toModel();
            return bigliettoService.update(biglietto).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteBiglietto(@PathVariable("id") Integer idBiglietto) {
        return bigliettoService.deleteById(idBiglietto);
    }

    @GetMapping("/v1/{id}")
    public BigliettoDTO getBigliettoById(@PathVariable("id") Integer idBiglietto) {
        return bigliettoService.findById(idBiglietto).toDto();
    }
}
