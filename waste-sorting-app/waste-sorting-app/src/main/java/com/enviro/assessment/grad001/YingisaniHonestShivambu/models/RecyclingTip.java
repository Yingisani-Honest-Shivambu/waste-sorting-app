package com.enviro.assessment.grad001.YingisaniHonestShivambu.models;

import jakarta.persistence.*;
import lombok.*;


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
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WasteCategory category;
}
