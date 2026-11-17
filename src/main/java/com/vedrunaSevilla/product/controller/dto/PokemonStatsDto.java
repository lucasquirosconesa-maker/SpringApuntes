package com.vedrunaSevilla.product.controller.dto;

import com.vedrunaSevilla.product.persistance.model.Pokemon;

import lombok.Data;

@Data 
public class PokemonStatsDto {
    private Pokemon pokemon;
    private Long id;
    private int hp;
    private int atk;
    private int spAtk;
    private int def;
    private int spDef;
    private int spd;
    private float height;
    private float weight;
}
