package com.enviro.assessment.grad001.YingisaniHonestShivambu.services;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.DisposalGuideline;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    @Autowired
    private WasteCategoryRepository categoryRepository;

    public List<DisposalGuidelineDTO> getAllGuidelines(){
        return  repository.findAll().stream()
                .map(guideline-> new DisposalGuidelineDTO(
                        guideline.getId(),
                        guideline.getTitle(),
                        guideline.getInstructions(),
                        guideline.getCategory().getId(),
                        guideline.getCategory().getName()
                )).collect(Collectors.toList());
    }

    public List<DisposalGuidelineDTO> getGuidelinesByCategory(Long categoryId){
      return repository.findByCategoryId(categoryId).stream()
                .map(guideline-> new DisposalGuidelineDTO(
                        guideline.getId(),
                        guideline.getTitle(),
                        guideline.getInstructions(),
                        guideline.getCategory().getId(),
                        guideline.getCategory().getName()
                )).collect(Collectors.toList());
    }
}
