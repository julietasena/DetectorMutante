package com.adn.DetectorMutante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adns")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sequence;

    @Column
    private boolean isMutant;
}