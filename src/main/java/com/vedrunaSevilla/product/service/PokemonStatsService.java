package com.vedrunaSevilla.product.service;

import com.vedrunaSevilla.product.persistance.model.PokemonStats;

public interface PokemonStatsService {
    public PokemonStats getPokemonStatsById(Long id);
    public PokemonStats createPokemonStats(PokemonStats PokemonStats);
    public PokemonStats updatePokemonStats(Long id, PokemonStats PokemonStats);
}
