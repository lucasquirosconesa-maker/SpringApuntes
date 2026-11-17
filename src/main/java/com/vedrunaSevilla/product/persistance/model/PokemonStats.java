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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "pokemon_abilities")
@NoArgsConstructor
@Data 
public class PokemonStats {
    @OneToOne ( fetch = FetchType.LAZY)
    @JoinColumn (name = "pokemon_id" , referencedColumnName="pokemon_id")
    private Pokemon pokemon;

    @Id 
    @Column (name = "pokemon_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "Hp")
    private int hp;

    @Column (name = "Attack")
    private int atk;

    @Column (name = "Sp.Attack")
    private int spAtk;

    @Column (name = "Defense")
    private int def;

    @Column (name = "Sp.Defense")
    private int spDef;

    @Column (name = "Speed")
    private int spd;

    @Column (name = "Height")
    private float height;

    @Column (name = "Weight")
    private float weight;
}
