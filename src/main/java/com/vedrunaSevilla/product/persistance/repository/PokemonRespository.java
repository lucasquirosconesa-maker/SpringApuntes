package com.vedrunaSevilla.product.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunaSevilla.product.persistance.model.Pokemon;

public interface PokemonRespository extends JpaRepository<Pokemon, Long> {

}
