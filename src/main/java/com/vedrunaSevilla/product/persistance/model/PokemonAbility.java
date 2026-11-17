package com.vedrunaSevilla.product.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "pokemon_abilities")
@NoArgsConstructor
@Data 
public class PokemonAbility {
    @Id 
    @Column (name = "pokemon_ability_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "pokemon_ability_name")
    private String name;
    @Column (name = "description")
    private String description;
}
