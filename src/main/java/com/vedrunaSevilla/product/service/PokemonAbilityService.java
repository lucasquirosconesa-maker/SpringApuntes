package com.vedrunaSevilla.product.service;

import java.util.List;

import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.persistance.model.PokemonAbility;

public interface PokemonAbilityService {
public List<PokemonAbility> getAllPokemonAbilitys();
    public List<PokemonAbility> getPokemonAbilitiesById(Long id);
    public List<Pokemon> getAbilityPokemonsById(Long id);
    public PokemonAbility createPokemonAbility(PokemonAbility PokemonAbility);
    public void addPokemonAbility(Long id, Long abilityId);
    public void deletePokemonAbility(Long id, Long abilityId);
}