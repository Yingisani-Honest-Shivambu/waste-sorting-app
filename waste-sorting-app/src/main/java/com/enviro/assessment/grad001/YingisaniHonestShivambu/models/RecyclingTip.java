package com.enviro.assessment.grad001.YingisaniHonestShivambu.models;

import jakarta.persistence.*;
import lombok.*;


/**
 * Represents a Recycling Tip entity in the database.
 * Each recycling tip is linked to a specific waste category.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "recycling_tips")
public class RecyclingTip {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false) // Title cannot be null
    private String title;

    @Column(nullable = false, length = 1000) // Content cannot be null
    private String content;

    // Many-to-One relationship with WasteCategory
    @ManyToOne
    @JoinColumn(name = "category_id")
    private WasteCategory category;

    /**
     * Constructor to initialize a RecyclingTip with required fields.
     */
    public RecyclingTip(String title, String content, WasteCategory category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
