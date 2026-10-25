package com.vedrunaSevilla.product.controller.converter;

import org.springframework.stereotype.Component;

import com.vedrunaSevilla.product.controller.dto.PokemonDto;
import com.vedrunaSevilla.product.persistance.model.Pokemon;

@Component 
public class Converter {

    public PokemonDto convertToDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getPokemonId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        pokemonDto.setDescription(pokemon.getDescription());
        return pokemonDto;
    }

    public Pokemon convertToEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        pokemon.setDescription(pokemonDto.getDescription());
        return pokemon;
    }
}