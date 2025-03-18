package com.enviro.assessment.grad001.YingisaniHonestShivambu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Data Transfer Object (DTO) for WasteCategory.
 * Used to expose only necessary data to API consumers, avoiding direct exposure of the entity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategoryDTO {
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    private int guidelinesCount;
    private int tipsCount;
}
