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
import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.service.PokemonService;

@RestController
@RequestMapping ("/api/v1/pokemons")
@CrossOrigin 
public class PokemonController {

    PokemonService pokemonService;
    Converter converter;

    PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping 
    public ResponseEntity<List<PokemonDto>> getAllPokemons() {
        return ResponseEntity.ok(pokemonService.getAllPokemons().stream().map(converter::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.getPokemonById(id);

        return ResponseEntity.status(HttpStatus.OK).body(converter.convertToDto(pokemon));
    }

    @PostMapping 
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto) {
        Pokemon pokemon = converter.convertToEntity(pokemonDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertToDto(pokemonService.createPokemon(pokemon)));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<PokemonDto> updatepokemon(@PathVariable Long id, @RequestBody PokemonDto pokemonDto) {
        Pokemon pokemon = converter.convertToEntity(pokemonDto);
        return ResponseEntity.ok(converter.convertToDto(pokemonService.updatePokemon(id, pokemon)));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletepokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();          
    }
}
