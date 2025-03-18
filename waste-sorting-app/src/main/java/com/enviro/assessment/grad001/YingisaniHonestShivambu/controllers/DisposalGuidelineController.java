package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * Controller for handling API requests related to Disposal Guidelines.
 * Exposes RESTful endpoints for managing guidelines.
 */
@RestController
@RequestMapping("/wastemanagementapi/guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    /**
     * Retrieves all disposal guidelines.
     *
     * @return List of DisposalGuidelineDTO objects.
     */
    @GetMapping
    public List<DisposalGuidelineDTO> getAllGuidelines() {
        return service.getAllDisposalGuidelines();
    }

    /**
     * Retrieves a specific disposal guideline by ID.
     *
     * @param id The ID of the guideline to retrieve.
     * @return DisposalGuidelineDTO object if found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDisposalGuidelineById(id));
    }

    /**
     * Creates a new disposal guideline linked to a specific waste category.
     *
     * @param dto The DisposalGuidelineDTO object containing the new guideline data.
     * @return The created DisposalGuidelineDTO.
     */
    @PostMapping
    public ResponseEntity<DisposalGuidelineDTO> createGuideline(@Valid @RequestBody DisposalGuidelineDTO dto) {
        return ResponseEntity.ok(service.createDisposalGuideline(dto));
    }

    /**
     * Updates an existing disposal guideline.
     *
     * @param id  The ID of the guideline to update.
     * @param dto The DisposalGuidelineDTO object with updated data.
     * @return The updated DisposalGuidelineDTO.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelineDTO dto) {
        return ResponseEntity.ok(service.updateDisposalGuideline(id, dto));
    }

    /**
     * Deletes a disposal guideline by ID.
     *
     * @param id The ID of the guideline to delete.
     * @return HTTP 204 No Content response if successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
