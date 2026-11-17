package com.vedrunaSevilla.product.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vedrunaSevilla.product.controller.dto.PokemonAbilityDto;
import com.vedrunaSevilla.product.controller.dto.PokemonDto;
import com.vedrunaSevilla.product.controller.dto.PokemonStatsDto;
import com.vedrunaSevilla.product.controller.dto.TrainerDto;
import com.vedrunaSevilla.product.persistance.model.Pokemon;
import com.vedrunaSevilla.product.persistance.model.PokemonAbility;
import com.vedrunaSevilla.product.persistance.model.PokemonStats;
import com.vedrunaSevilla.product.persistance.model.Trainer;

@Component 
public class Converter {

    public PokemonDto convertToDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
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

    public TrainerDto convertToDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainer.getId());
        trainerDto.setName(trainer.getName());
        trainerDto.setHometown(trainer.getHometown());
        List<PokemonDto> pokList = new ArrayList();
        for (Pokemon pokemon : trainer.getPokemonList()) {
            pokList.add(convertToDto(pokemon));
        }
        trainerDto.setPokemonList(pokList);
        return trainerDto;
    }
    public Trainer convertToEntity(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setName(trainerDto.getName());
        trainer.setHometown(trainerDto.getHometown());
        List<Pokemon> pokList = new ArrayList();
        for (PokemonDto pokemon : trainerDto.getPokemonList()) {
            pokList.add(convertToEntity(pokemon));
        }
        trainer.setPokemonList(pokList);
        return trainer;
    }

    public PokemonStatsDto convertToDto(PokemonStats pokemonStats) {
        PokemonStatsDto dto = new PokemonStatsDto();
        dto.setPokemon(pokemonStats.getPokemon());
        dto.setId(pokemonStats.getId());
        dto.setHp(pokemonStats.getHp());
        dto.setAtk(pokemonStats.getAtk());
        dto.setSpAtk(pokemonStats.getSpAtk());
        dto.setDef(pokemonStats.getDef());
        dto.setSpDef(pokemonStats.getSpDef());
        dto.setSpd(pokemonStats.getSpd());
        dto.setHeight(pokemonStats.getHeight());
        dto.setWeight(pokemonStats.getWeight());
        return dto;
    }
    public PokemonStats convertToEntity(PokemonStatsDto dto) {
        PokemonStats pokemonStats = new PokemonStats();
        pokemonStats.setPokemon(dto.getPokemon());
        pokemonStats.setHp(dto.getHp());
        pokemonStats.setAtk(dto.getAtk());
        pokemonStats.setSpAtk(dto.getSpAtk());
        pokemonStats.setDef(dto.getDef());
        pokemonStats.setSpDef(dto.getSpDef());
        pokemonStats.setSpd(dto.getSpd());
        pokemonStats.setHeight(dto.getHeight());
        pokemonStats.setWeight(dto.getWeight());
        return pokemonStats;
    }

    public PokemonAbilityDto convertToDto(PokemonAbility pokemonAbility) {
        PokemonAbilityDto pokemonAbilityDto = new PokemonAbilityDto();
        pokemonAbilityDto.setId(pokemonAbility.getId());
        pokemonAbilityDto.setName(pokemonAbility.getName());
        pokemonAbilityDto.setDescription(pokemonAbility.getDescription());
        return pokemonAbilityDto;
    }
    public PokemonAbility convertToEntity(PokemonAbilityDto pokemonAbilityDto) {
        PokemonAbility pokemonAbility = new PokemonAbility();
        pokemonAbility.setName(pokemonAbilityDto.getName());
        pokemonAbility.setDescription(pokemonAbilityDto.getDescription());
        return pokemonAbility;
    }
}