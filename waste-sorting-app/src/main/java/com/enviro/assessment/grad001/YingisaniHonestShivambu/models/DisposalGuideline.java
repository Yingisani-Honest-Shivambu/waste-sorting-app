package com.enviro.assessment.grad001.YingisaniHonestShivambu.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a Disposal Guideline entity in the database.
 * Each guideline is linked to a specific waste category.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false) // Title is required
    private String title;

    @Column(nullable = false, length = 1000) // Instructions cannot be null
    private String Instructions;

    // Many-to-One relationship with WasteCategory
    @ManyToOne
    @JoinColumn( name = "category_id", nullable = false)
    private WasteCategory category;

    /**
     * Constructor to initialize DisposalGuideline with required fields.
     */
    public DisposalGuideline(String title, String instructions, WasteCategory category) {
        this.title = title;
        this.Instructions = instructions;
        this.category = category;
    }
}
