package com.vedrunaSevilla.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunaSevilla.product.persistance.model.PokemonAbility;
import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.persistance.repository.PokemonAbilityRespository;
import com.vedrunaSevilla.product.persistance.repository.PokemonRespository;

@Service
public class PokemonAbilityServiceImpl implements PokemonAbilityService {

    PokemonAbilityRespository pokemonAbilityRespository;
    PokemonRespository pokemonRespository;

    public PokemonAbilityServiceImpl(PokemonAbilityRespository pokemonAbilityRespository, PokemonRespository pokemonRespository) {
        this.pokemonAbilityRespository = pokemonAbilityRespository;
        this.pokemonRespository = pokemonRespository;
    }

    @Override
    public List<PokemonAbility> getAllPokemonAbilitys() {
        return pokemonAbilityRespository.findAll();
    }

    @Override 
    public List<PokemonAbility> getPokemonAbilitiesById(Long id) {
        Pokemon pokemon = pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));;
        List<PokemonAbility> pokemonAbilities = pokemon.getAbilityList();
        return pokemonAbilities;
    }
    @Override 
    public List<Pokemon> getAbilityPokemonsById(Long id) {
        PokemonAbility pokemonAb = pokemonAbilityRespository.findById(id).orElseThrow(() -> new RuntimeException("PokemonAbility not found with id: " + id));
        List<Pokemon> pokemonAbilities = new ArrayList<>();
        List<Pokemon> allPokemons = pokemonRespository.findAll();
        for (Pokemon pokemon2 : allPokemons) {
            if (pokemon2.getAbilityList().contains(pokemonAb)) {
                pokemonAbilities.add(pokemon2);
            }
        }
        return pokemonAbilities;
    }

    @Override
    public PokemonAbility createPokemonAbility(PokemonAbility pokemonAbility) {
        return pokemonAbilityRespository.save(pokemonAbility);
    }

    @Override
    public void addPokemonAbility(Long id, Long abilityId) {
        PokemonAbility existingPokemonAbility = pokemonAbilityRespository.findById(abilityId).orElseThrow(() -> new RuntimeException("PokemonAbility not found with id: " + id));
        Pokemon pokemon = pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));;
        pokemon.getAbilityList().remove(existingPokemonAbility);
    }

    @Override 
    public void deletePokemonAbility(Long id, Long abilityId) {
        PokemonAbility existingPokemonAbility = pokemonAbilityRespository.findById(abilityId).orElseThrow(() -> new RuntimeException("PokemonAbility not found with id: " + id));
        Pokemon pokemon = pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));;
        if (pokemon.getAbilityList().contains(existingPokemonAbility)) {
            pokemon.getAbilityList().remove(existingPokemonAbility);
        } else {
            throw new RuntimeException("PokemonAbility not found with id: " + id);
        }
    }
}