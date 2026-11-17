package com.vedrunaSevilla.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunaSevilla.product.controller.converter.Converter;
import com.vedrunaSevilla.product.controller.dto.PokemonAbilityDto;
import com.vedrunaSevilla.product.controller.dto.PokemonDto;
import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.persistance.model.PokemonAbility;
import com.vedrunaSevilla.product.service.PokemonAbilityService;

@RestController
@RequestMapping ("/api/v1")
@CrossOrigin 
public class PokemonAbilityController {

    PokemonAbilityService pokemonAbilityService;
    Converter converter;

    PokemonAbilityController(PokemonAbilityService pokemonAbilityService) {
        this.pokemonAbilityService = pokemonAbilityService;
    }

    @GetMapping ("/abilities")
    public ResponseEntity<List<PokemonAbilityDto>> getAllPokemonAbilitys() {
        return ResponseEntity.ok(pokemonAbilityService.getAllPokemonAbilitys().stream().map(converter::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping ("/abilities/{id}/pokemons")
    public ResponseEntity<List<PokemonDto>> getAbilityPokemonsById(@PathVariable Long id) {
        List<Pokemon> pokemonAbility = pokemonAbilityService.getAbilityPokemonsById(id);
        List<PokemonDto> pokemonDtos = new ArrayList<>();
        for (Pokemon pokemon : pokemonAbility) {
            pokemonDtos.add(converter.convertToDto(pokemon));
        }
        return ResponseEntity.status(HttpStatus.OK).body(pokemonDtos);
    }

    @GetMapping ("/pokemons/{id}/abilities")
    public ResponseEntity<List<PokemonAbilityDto>> getPokemonAbilitiesById(@PathVariable Long id) {
        List<PokemonAbility> pokemonAbility = pokemonAbilityService.getPokemonAbilitiesById(id);
        List<PokemonAbilityDto> pokemonAbilityDtos = new ArrayList<>();
        for (PokemonAbility pokemonAbility2 : pokemonAbility) {
            pokemonAbilityDtos.add(converter.convertToDto(pokemonAbility2));
        }
        return ResponseEntity.status(HttpStatus.OK).body(pokemonAbilityDtos);
    }

    @PostMapping ("/abilities")
    public ResponseEntity<PokemonAbilityDto> createPokemonAbility(@RequestBody PokemonAbilityDto pokemonAbilityDto) {
        PokemonAbility pokemonAbility = converter.convertToEntity(pokemonAbilityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertToDto(pokemonAbilityService.createPokemonAbility(pokemonAbility)));
    }

    @PostMapping ("/pokemons/{id}/abilities/{abilityId}")
    public ResponseEntity<Void> addPokemonAbility(@PathVariable Long id, @PathVariable Long abilityId) {
        pokemonAbilityService.addPokemonAbility(id, abilityId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/pokemons/{id}/abilities/{abilityId}")
    public ResponseEntity<Void> deletepokemonAbility(@PathVariable Long id, @PathVariable Long abilityId) {
        pokemonAbilityService.deletePokemonAbility(id, abilityId);
        return ResponseEntity.noContent().build();
    }
}
