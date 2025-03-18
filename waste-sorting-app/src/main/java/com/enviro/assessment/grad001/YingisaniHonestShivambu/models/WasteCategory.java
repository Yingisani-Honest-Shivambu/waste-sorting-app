package com.enviro.assessment.grad001.YingisaniHonestShivambu.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Represents a Waste Category entity in the database.
 * Each waste category can have multiple disposal guidelines and recycling tips.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "waste_categories")

public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // Ensures name cannot be null or duplicate
    private String name;

    // One-to-many relationship with DisposalGuideline
    // One category can have multiple recycling tips
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisposalGuideline> guidelines;

    // One-to-many relationship with RecyclingTip
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecyclingTip> tips;

    /**
     * Constructor to initialize WasteCategory with only a name.
     * Used when creating new instances.
     */
    public WasteCategory(String name) {
        this.name = name;
    }

}
