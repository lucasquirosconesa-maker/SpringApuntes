package com.vedrunaSevilla.product.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunaSevilla.product.persistance.model.PokemonAbility;

public interface PokemonAbilityRespository extends JpaRepository<PokemonAbility, Long> {

}