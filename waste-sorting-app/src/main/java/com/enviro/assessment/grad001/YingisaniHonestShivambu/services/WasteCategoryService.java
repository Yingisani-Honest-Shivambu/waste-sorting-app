package com.enviro.assessment.grad001.YingisaniHonestShivambu.services;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.WasteCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for WasteCategory.
 * Handles business logic and interacts with the repository.
 */
@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    /**
     * Retrieves all waste categories as a list of DTOs.
     */
    public List<WasteCategoryDTO> getAllWasteCategories(){
        return repository.findAll().stream()
                .map(category -> new WasteCategoryDTO(
                        category.getId(),
                        category.getName(),
                        category.getGuidelines().size(),
                        category.getTips().size()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a single waste category by its ID.
     * Throws an exception if not found.
     */
    public WasteCategoryDTO getWasteCategoryById(Long id){
        WasteCategory category = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Waste Category was not found with id: "+id));
        return new WasteCategoryDTO(
                category.getId(),
                category.getName(),
                category.getGuidelines().size(),
                category.getTips().size());
    }

    /**
     * Creates a new waste category if it doesn't already exist.
     */
    public WasteCategoryDTO createWasteCategory( WasteCategoryDTO dto){
        WasteCategory category = new WasteCategory();
        category.setName(dto.getName());
        WasteCategory savedCategory = repository.save(category);
        return new WasteCategoryDTO(
                savedCategory.getId(),
                savedCategory.getName(),
                0,
                0
        );
    }

    /**
     * Updates an existing waste category by ID.
     * Ensures the updated name is unique.
     */
    public WasteCategoryDTO updateWasteCategory(Long id, WasteCategoryDTO dto) {
        WasteCategory category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + id));

        category.setName(dto.getName());  //Update name
        WasteCategory updatedCategory = repository.save(category);  //Save updates

        //Return updated data including guidelines and tips count
        return new WasteCategoryDTO(
                updatedCategory.getId(),
                updatedCategory.getName(),
                updatedCategory.getGuidelines().size(),  //Count of guidelines
                updatedCategory.getTips().size()  //Count of tips
        );
    }

    /**
     * Deletes a waste category by ID.
     */
    public void deleteWasteCategory(Long id){
        repository.deleteById(id);
    }
}
