package com.vedrunaSevilla.product.service;

import java.util.List;

import com.vedrunaSevilla.product.persistance.model.Pokemon;

public interface PokemonService {
public List<Pokemon> getAllPokemons();
    public Pokemon getPokemonById(Long id);
    public Pokemon createPokemon(Pokemon Pokemon);
    public Pokemon updatePokemon(Long id, Pokemon Pokemon);
    public void deletePokemon(Long id);
}
