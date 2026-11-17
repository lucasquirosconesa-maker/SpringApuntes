package com.vedrunaSevilla.product.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunaSevilla.product.persistance.model.PokemonStats;

public interface PokemonStatsRespository extends JpaRepository<PokemonStats, Long> {

}