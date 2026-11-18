package com.vedrunaSevilla.product.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "pokemon_stats")
@NoArgsConstructor
@Getter
@Setter
public class PokemonStats {
    @OneToOne ( fetch = FetchType.LAZY)
    @JoinColumn (name = "pokemon_id" , referencedColumnName="id")
    private Pokemon pokemon;

    @Id 
    @Column (name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "Hp")
    private int hp;

    @Column (name = "attack")
    private int atk;

    @Column (name = "defense")
    private int def;

    @Column (name = "speed")
    private int spd;

    @Column (name = "height")
    private float height;

    @Column (name = "weight")
    private float weight;
}
