package com.vedrunaSevilla.product.persistance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "pokemons")
@NoArgsConstructor 
@Data 
public class Pokemon {
    @Id 
    @Column (name = "pokemon_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "pokemon_name")
    private String name;

    @Column(name = "pokemon_type") 
    private String type;

    @Column(name = "pokemon_description") 
    private String description;

    @Column (name = "pokemon_url_image")
    private String url;

    @ManyToOne (fetch = FetchType.LAZY)
    private Trainer trainer;

    @ManyToMany ( fetch = FetchType.LAZY)
    @JoinTable (name = "pokemon_abilities", joinColumns = {@JoinColumn(name = "pokemon_id", referencedColumnName = "pokemon_id")}
    , inverseJoinColumns = {@JoinColumn(name = "ability_id", referencedColumnName = "ability_id")})
    List<PokemonAbility> abilityList;
}
