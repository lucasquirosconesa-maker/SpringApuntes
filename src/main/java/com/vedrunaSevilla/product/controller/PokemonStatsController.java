package com.vedrunaSevilla.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunaSevilla.product.controller.converter.Converter;
import com.vedrunaSevilla.product.controller.dto.PokemonStatsDto;
import com.vedrunaSevilla.product.persistance.model.PokemonStats;
import com.vedrunaSevilla.product.service.PokemonStatsService;

@RestController
@RequestMapping ("/api/v1/pokemons/{id}/stats")
@CrossOrigin 
public class PokemonStatsController {

    PokemonStatsService pokemonStatsService;
    Converter converter;

    PokemonStatsController(PokemonStatsService pokemonStatsService) {
        this.pokemonStatsService = pokemonStatsService;
    }

    @GetMapping 
    public ResponseEntity<PokemonStatsDto> getPokemonStatsById(@PathVariable Long id) {
        PokemonStats pokemonStats = pokemonStatsService.getPokemonStatsById(id);

        return ResponseEntity.status(HttpStatus.OK).body(converter.convertToDto(pokemonStats));
    }

    @PostMapping 
    public ResponseEntity<PokemonStatsDto> createPokemonStats(@RequestBody PokemonStatsDto pokemonStatsDto) {
        PokemonStats pokemonStats = converter.convertToEntity(pokemonStatsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertToDto(pokemonStatsService.createPokemonStats(pokemonStats)));
    }
    @PutMapping 
    public ResponseEntity<PokemonStatsDto> updatepokemonStats(@PathVariable Long id, @RequestBody PokemonStatsDto pokemonStatsDto) {
        PokemonStats pokemonStats = converter.convertToEntity(pokemonStatsDto);
        return ResponseEntity.ok(converter.convertToDto(pokemonStatsService.updatePokemonStats(id, pokemonStats)));
    }
}