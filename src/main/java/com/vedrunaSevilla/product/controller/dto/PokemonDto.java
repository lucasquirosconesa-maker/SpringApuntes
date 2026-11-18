package com.vedrunaSevilla.product.controller.dto;

import java.util.List;
import lombok.Data;

@Data 
public class PokemonDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private Long trainerId;
    private List<PokemonAbilityDto> abilityList;
}
