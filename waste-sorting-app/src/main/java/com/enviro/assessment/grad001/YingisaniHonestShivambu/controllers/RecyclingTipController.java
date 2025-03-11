package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wastemanagementapi/tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService service;

    @GetMapping
    public List<RecyclingTipDTO> getAllTips() {
        return service.getAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecyclingTipById(id));
    }

    @PostMapping
    public ResponseEntity<RecyclingTipDTO> createTip(@Valid @RequestBody RecyclingTipDTO dto) {
        return ResponseEntity.ok(service.createRecyclingTip(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTipDTO dto) {
        return ResponseEntity.ok(service.updateRecyclingTip(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
