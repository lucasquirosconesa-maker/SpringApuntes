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
@Table (name = "pokemons")
@NoArgsConstructor 
@Data 
public class Pokemon {

    @Id 
    @Column (name = "pokemon_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pokemonId;

    @Column (name = "pokemon_name")
    private String name;

    @Column(name = "pokemon_type") 
    private String type;

    @Column(name = "pokemon_description") 
    private String description;

    @Column (name = "pokemon_url_image")
    private String url;
}
