package com.enviro.assessment.grad001.YingisaniHonestShivambu.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Data Transfer Object (DTO) for RecyclingTip.
 * Used to expose only necessary data while preventing direct entity exposure.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecyclingTipDTO {
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    @Size(min = 10, max = 500, message = "Content must be between 10 and 500 characters")
    private String content;

    private Long categoryId;
    private String categoryName;
}
