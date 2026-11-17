package com.vedrunaSevilla.product.controller.dto;

import java.util.List;
import com.vedrunaSevilla.product.persistance.model.PokemonAbility;
import com.vedrunaSevilla.product.persistance.model.Trainer;
import lombok.Data;

@Data 
public class PokemonDto {
    private Long id;
    private String name;
    private String type;
    private String description;
    private Trainer trainer;
    private List<PokemonAbility> abilityList;
}
