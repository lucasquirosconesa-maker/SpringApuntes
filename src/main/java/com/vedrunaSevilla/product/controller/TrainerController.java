package com.vedrunaSevilla.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunaSevilla.product.controller.converter.Converter;
import com.vedrunaSevilla.product.controller.dto.PokemonDto;
import com.vedrunaSevilla.product.controller.dto.TrainerDto;
import com.vedrunaSevilla.product.persistance.model.Trainer;
import com.vedrunaSevilla.product.service.TrainerService;

@RestController
@RequestMapping ("/api/v1/trainers")
@CrossOrigin 
public class TrainerController {

    TrainerService trainerService;
    Converter converter;

    TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping 
    public ResponseEntity<List<TrainerDto>> getAllTrainers() {
        return ResponseEntity.ok(trainerService.getAllTrainers().stream().map(converter::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<TrainerDto> getTrainerById(@PathVariable Long id) {
        Trainer trainer = trainerService.getTrainerById(id);

        return ResponseEntity.status(HttpStatus.OK).body(converter.convertToDto(trainer));
    }

    @GetMapping ("/{id}/pokemons")
    public ResponseEntity<List<PokemonDto>> getTrainerPokemons(@PathVariable Long id) {
        Trainer trainer = trainerService.getTrainerById(id);

        return ResponseEntity.status(HttpStatus.OK).body(converter.convertToDto(trainer).getPokemonList());
    }

    @PostMapping 
    public ResponseEntity<TrainerDto> createTrainer(@RequestBody TrainerDto trainerDto) {
        Trainer trainer = converter.convertToEntity(trainerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertToDto(trainerService.createTrainer(trainer)));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<TrainerDto> updatetrainer(@PathVariable Long id, @RequestBody TrainerDto trainerDto) {
        Trainer trainer = converter.convertToEntity(trainerDto);
        return ResponseEntity.ok(converter.convertToDto(trainerService.updateTrainer(id, trainer)));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletetrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return ResponseEntity.noContent().build();          
    }
}