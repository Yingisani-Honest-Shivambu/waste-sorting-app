package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wastemanagementapi/guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuidelineDTO> getAllGuidelines() {
        return service.getAllDisposalGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDisposalGuidelineById(id));
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelineDTO> createGuideline(@Valid @RequestBody DisposalGuidelineDTO dto) {
        return ResponseEntity.ok(service.createDisposalGuideline(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelineDTO dto) {
        return ResponseEntity.ok(service.updateDisposalGuideline(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
