package com.enviro.assessment.grad001.YingisaniHonestShivambu.models;

import jakarta.persistence.*;
import lombok.*;


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

    private String title;
    private String Instructions;

    @ManyToOne
    @JoinColumn( name = "category_id", nullable = false)
    private WasteCategory category;
}
