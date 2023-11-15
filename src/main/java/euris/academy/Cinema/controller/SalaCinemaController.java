package euris.academy.Cinema.controller;

import euris.academy.Cinema.DTO.SalaCinemaDTO;
import euris.academy.Cinema.Entity.SalaCinema;
import euris.academy.Cinema.exception.IdMustBeNullException;
import euris.academy.Cinema.exception.IdMustNotBeNullException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import euris.academy.Cinema.service.SalaCinemaService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/sala-cinema")
public class SalaCinemaController {
    SalaCinemaService salaCinemaService;
    @GetMapping("/v1")
    public List<SalaCinemaDTO> getAllSalaCinema() {
        return salaCinemaService.findAll().stream().map(SalaCinema::toDto).toList();
    }

    @PostMapping("/v1")
    public SalaCinemaDTO saveSalaCinema(@RequestBody SalaCinemaDTO salaCinemaDTO) {
        try{
            SalaCinema salaCinema = salaCinemaDTO.toModel();
            return salaCinemaService.insert(salaCinema).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public SalaCinemaDTO updateSalaCinema(@RequestBody SalaCinemaDTO salaCinemaDTO){
        try{
            SalaCinema salaCinema= salaCinemaDTO.toModel();
            return salaCinemaService.update(salaCinema).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    public Boolean deleteSalaCinema(@PathVariable("id") Integer idSalaCinema) {
        return salaCinemaService.deleteById(idSalaCinema);
    }

    @GetMapping("/v1/{id}")
    public SalaCinemaDTO getSalaCinemaById(@PathVariable("id") Integer idSalaCinema) {
        return salaCinemaService.findById(idSalaCinema).toDto();
    }
}
