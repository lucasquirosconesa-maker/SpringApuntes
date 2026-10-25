package com.vedrunaSevilla.product.controller;

import java.util.List;

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

import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.service.PokemonService;

@RestController
@RequestMapping ("/api/v1/pokemons")
@CrossOrigin 
public class PokemonController {

    PokemonService pokemonService;

    PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping 
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping 
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.createPokemon(pokemon));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Pokemon> updatepokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.updatePokemon(id, pokemon));
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletepokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();          
    }
}
