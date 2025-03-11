package com.enviro.assessment.grad001.YingisaniHonestShivambu.services;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.DisposalGuideline;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
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

    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        return repository.findAll().stream()
                .map(guideline -> new DisposalGuidelineDTO(
                        guideline.getId(),
                        guideline.getTitle(),
                        guideline.getInstructions(),
                        guideline.getCategory().getId(),
                        guideline.getCategory().getName()
                ))
                .collect(Collectors.toList());
    }

    public DisposalGuidelineDTO getDisposalGuidelineById(Long id) {
        DisposalGuideline guideline = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found with id: " + id));

        return new DisposalGuidelineDTO(
                guideline.getId(),
                guideline.getTitle(),
                guideline.getInstructions(),
                guideline.getCategory().getId(),
                guideline.getCategory().getName()
        );
    }

    public DisposalGuidelineDTO createDisposalGuideline(DisposalGuidelineDTO dto) {
        WasteCategory category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + dto.getCategoryId()));

        DisposalGuideline guideline = new DisposalGuideline(null, dto.getTitle(), dto.getInstructions(), category);
        DisposalGuideline savedGuideline = repository.save(guideline);

        return new DisposalGuidelineDTO(
                savedGuideline.getId(),
                savedGuideline.getTitle(),
                savedGuideline.getInstructions(),
                savedGuideline.getCategory().getId(),
                savedGuideline.getCategory().getName()
        );
    }

    public DisposalGuidelineDTO updateDisposalGuideline(Long id, DisposalGuidelineDTO dto) {
        DisposalGuideline guideline = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found with id: " + id));

        guideline.setTitle(dto.getTitle());
        guideline.setInstructions(dto.getInstructions());
        DisposalGuideline updatedGuideline = repository.save(guideline);

        return new DisposalGuidelineDTO(
                updatedGuideline.getId(),
                updatedGuideline.getTitle(),
                updatedGuideline.getInstructions(),
                updatedGuideline.getCategory().getId(),
                updatedGuideline.getCategory().getName()
        );
    }

    public void deleteDisposalGuideline(Long id) {
        DisposalGuideline guideline = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found with id: " + id));
        repository.delete(guideline);
    }
}
