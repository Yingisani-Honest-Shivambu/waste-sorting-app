package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wastemanagementapi/categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategoryDTO> getAllCategories(){
        return service.getAllWasteCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(service.getWasteCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<WasteCategoryDTO> createCategory(@Valid @RequestBody WasteCategoryDTO dto){
        return ResponseEntity.ok(service.createWasteCategory(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategoryDTO dto) {
        return ResponseEntity.ok(service.updateWasteCategory(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        service.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
