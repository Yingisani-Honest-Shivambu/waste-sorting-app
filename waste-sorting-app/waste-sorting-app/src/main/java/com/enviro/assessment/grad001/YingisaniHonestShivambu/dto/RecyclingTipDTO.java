package com.enviro.assessment.grad001.YingisaniHonestShivambu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecyclingTipDTO {
    private Long id;
    private String title;
    private String Content;
    private Long categoryId;
    private String categoryName;
}
