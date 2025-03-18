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

/**
 * Service layer for DisposalGuideline.
 * Handles business logic and ensures valid category associations.
 */
@Service
public class DisposalGuidelineService {
    @Autowired
    private DisposalGuidelineRepository repository;

    @Autowired
    private WasteCategoryRepository categoryRepository;

    /**
     * Retrieves all disposal guidelines as DTOs.
     */
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


    /**
     * Retrieves a single disposal guideline by its ID.
     * Throws an exception if not found.
     */
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

    /**
     * Creates a new disposal guideline under a specified category.
     * Ensures the category exists before saving.
     */
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

    /**
     * updates a disposal guideline by ID.
     */
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

    /**
     * Deletes a disposal guideline by ID.
     */
    public void deleteDisposalGuideline(Long id) {
        DisposalGuideline guideline = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal Guideline not found with id: " + id));
        repository.delete(guideline);
    }
}
