package com.vedrunaSevilla.product.service;

import org.springframework.stereotype.Service;

import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.persistance.model.PokemonStats;
import com.vedrunaSevilla.product.persistance.repository.PokemonRespository;
import com.vedrunaSevilla.product.persistance.repository.PokemonStatsRespository;

@Service
public class PokemonStatsServiceImpl implements PokemonStatsService {

    PokemonStatsRespository pokemonStatsRespository;
    PokemonRespository pokemonRespository;

    public PokemonStatsServiceImpl(PokemonStatsRespository pokemonStatsRespository, PokemonRespository pokemonRespository) {
        this.pokemonStatsRespository = pokemonStatsRespository;
        this.pokemonRespository = pokemonRespository;
    }

    @Override 
    public PokemonStats getPokemonStatsById(Long id) {
        Pokemon pokemon = pokemonRespository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));
        Long ide = (long) 0;
        for (PokemonStats pokemonStats : pokemonStatsRespository.findAll()) {
            if (pokemonStats.getPokemon().equals(pokemon)) {
                ide = pokemonStats.getId();
                break;
            }
        }
        return pokemonStatsRespository.findById(ide).orElseThrow(() -> new RuntimeException("PokemonStats not found for Pokemon with id: " + id));
    }

    @Override
    public PokemonStats createPokemonStats(PokemonStats pokemonStats) {
        return pokemonStatsRespository.save(pokemonStats);
    }
    @Override 
    public PokemonStats updatePokemonStats(Long id, PokemonStats pokemonStats) {
        PokemonStats existingPokemonStats = getPokemonStatsById(id);
        existingPokemonStats.setPokemon(pokemonStats.getPokemon());
        existingPokemonStats.setId(pokemonStats.getId());
        existingPokemonStats.setHp(pokemonStats.getHp());
        existingPokemonStats.setAtk(pokemonStats.getAtk());
        existingPokemonStats.setDef(pokemonStats.getDef());
        existingPokemonStats.setSpd(pokemonStats.getSpd());
        existingPokemonStats.setHeight(pokemonStats.getHeight());
        existingPokemonStats.setWeight(pokemonStats.getWeight());

        return pokemonStatsRespository.save(existingPokemonStats);
    }
}
