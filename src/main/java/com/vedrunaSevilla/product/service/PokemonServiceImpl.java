package com.vedrunaSevilla.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.persistance.repository.PokemonRespository;

@Service
public class PokemonServiceImpl implements PokemonService {

    PokemonRespository pokemonRespository;

    public PokemonServiceImpl(PokemonRespository pokemonRespository) {
        this.pokemonRespository = pokemonRespository;
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRespository.findAll();
    }

    @Override 
    public Pokemon getPokemonById(Long id) {
        return pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRespository.save(pokemon);
    }
    @Override 
    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Pokemon existingPokemon = pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));
        existingPokemon.setName(pokemon.getName());
        existingPokemon.setDescription(pokemon.getDescription());
        existingPokemon.setType(pokemon.getType());
        return pokemonRespository.save(existingPokemon);
    }
    @Override 
    public void deletePokemon(Long id) {
        Pokemon existingPokemon = pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));
        pokemonRespository.delete(existingPokemon);
    }
}
