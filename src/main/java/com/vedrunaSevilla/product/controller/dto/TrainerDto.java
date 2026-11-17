package com.vedrunaSevilla.product.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class TrainerDto {
    private Long id;
    private String name;
    private String hometown;
    List<PokemonDto> pokemonList;
}
