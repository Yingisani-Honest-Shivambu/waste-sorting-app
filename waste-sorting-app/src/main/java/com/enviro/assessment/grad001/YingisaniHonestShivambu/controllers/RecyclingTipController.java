package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * Controller for handling API requests related to Recycling Tips.
 * Exposes RESTful endpoints for CRUD operations.
 */
@RestController
@RequestMapping("/wastemanagementapi/tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService service;

    /**
     * Retrieves all recycling tips.
     * @return ResponseEntity containing a list of RecyclingTipDTO objects.
     */
    @GetMapping
    public List<RecyclingTipDTO> getAllTips() {
        return service.getAllRecyclingTips();
    }

    /**
     * Retrieves a specific recycling tip by ID.
     * @param id The ID of the recycling tip to retrieve.
     * @return ResponseEntity containing the RecyclingTipDTO object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecyclingTipById(id));
    }

    /**
     * Creates a new recycling tip.
     * @param dto RecyclingTipDTO object containing new tip details.
     * @return ResponseEntity containing the created RecyclingTipDTO.
     */
    @PostMapping
    public ResponseEntity<RecyclingTipDTO> createTip(@Valid @RequestBody RecyclingTipDTO dto) {
        return ResponseEntity.ok(service.createRecyclingTip(dto));
    }

    /**
     * Updates an existing recycling tip.
     * @param id The ID of the recycling tip to update.
     * @param dto RecyclingTipDTO object containing updated details.
     * @return ResponseEntity containing the updated RecyclingTipDTO.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTipDTO dto) {
        return ResponseEntity.ok(service.updateRecyclingTip(id, dto));
    }

    /**
     * Deletes a recycling tip by ID.
     * @param id The ID of the recycling tip to delete.
     * @return HTTP 204 No Content response if successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
