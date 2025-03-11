package com.enviro.assessment.grad001.YingisaniHonestShivambu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisposalGuidelineDTO {
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String title;

    @NotBlank(message = "Instructions cannot be empty")
    @Size(min = 10, max = 500, message = "Instructions must be between 10 and 500 characters")
    private String instructions;
    private Long categoryId;
    private String categoryName;
}
