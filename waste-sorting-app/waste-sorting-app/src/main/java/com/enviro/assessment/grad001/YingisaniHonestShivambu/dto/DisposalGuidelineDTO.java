package com.enviro.assessment.grad001.YingisaniHonestShivambu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisposalGuidelineDTO {
    private Long id;
    private String title;
    private String instructions;
    private Long categoryId;
    private String categoryName;
}
