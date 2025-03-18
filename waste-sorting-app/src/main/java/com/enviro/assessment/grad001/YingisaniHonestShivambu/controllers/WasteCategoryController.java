package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling API requests related to Waste Categories.
 * Exposes RESTful endpoints for CRUD operations on waste categories.
 */
@RestController
@RequestMapping("/wastemanagementapi/categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    /**
     * Retrieves all waste categories.
     *
     * @return ResponseEntity containing a list of WasteCategoryDTO objects.
     */
    @GetMapping
    public List<WasteCategoryDTO> getAllCategories(){
        return service.getAllWasteCategories();
    }


    /**
     * Retrieves a specific waste category by ID.
     *
     * @param id The ID of the waste category to retrieve.
     * @return ResponseEntity containing the WasteCategoryDTO object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(service.getWasteCategoryById(id));
    }

    /**
     * Creates a new waste category.
     * Ensures that the category does not already exist.
     *
     * @param dto WasteCategoryDTO object containing new category details.
     * @return ResponseEntity containing the created WasteCategoryDTO.
     */
    @PostMapping
    public ResponseEntity<WasteCategoryDTO> createCategory(@Valid @RequestBody WasteCategoryDTO dto){
        return ResponseEntity.ok(service.createWasteCategory(dto));
    }

    /**
     * Updates an existing waste category.
     * Ensures the category exists before performing the update.
     *
     * @param id  The ID of the waste category to update.
     * @param dto WasteCategoryDTO object containing updated details.
     * @return ResponseEntity containing the updated WasteCategoryDTO.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategoryDTO dto) {
        return ResponseEntity.ok(service.updateWasteCategory(id, dto));
    }

    /**
     * Deletes a waste category by ID.
     * If the category does not exist, an appropriate response is returned.
     *
     * @param id The ID of the waste category to delete.
     * @return HTTP 204 No Content response if successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        service.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
