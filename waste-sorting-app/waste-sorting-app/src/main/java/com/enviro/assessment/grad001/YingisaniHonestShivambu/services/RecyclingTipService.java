package com.enviro.assessment.grad001.YingisaniHonestShivambu.services;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.RecyclingTip;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.RecyclingTipRepository;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    @Autowired
    private WasteCategoryRepository categoryRepository;

    public List<RecyclingTipDTO> getAllRecyclingTips() {
        return repository.findAll().stream()
                .map(tip -> new RecyclingTipDTO(
                        tip.getId(),
                        tip.getTitle(),
                        tip.getContent(),
                        tip.getCategory().getId(),
                        tip.getCategory().getName()))
                .collect(Collectors.toList());
    }

    public RecyclingTipDTO getRecyclingTipById(Long id) {
        RecyclingTip tip = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recycling Tip not found with id: " + id));
        return new RecyclingTipDTO(
                tip.getId(),
                tip.getTitle(),
                tip.getContent(),
                tip.getCategory().getId(),
                tip.getCategory().getName());
    }

    public RecyclingTipDTO createRecyclingTip(RecyclingTipDTO dto) {
        WasteCategory category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + dto.getCategoryId()));

        RecyclingTip tip = new RecyclingTip(null, dto.getTitle(), dto.getContent(), category);
        RecyclingTip savedTip = repository.save(tip);
        return new RecyclingTipDTO(
                savedTip.getId(),
                savedTip.getTitle(),
                savedTip.getContent(),
                savedTip.getCategory().getId(),
                tip.getCategory().getName());
    }

    public RecyclingTipDTO updateRecyclingTip(Long id, RecyclingTipDTO dto) {
        RecyclingTip tip = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recycling Tip not found with id: " + id));

        tip.setTitle(dto.getTitle());
        tip.setContent(dto.getContent());
        RecyclingTip updatedTip = repository.save(tip);

        return new RecyclingTipDTO(
                updatedTip.getId(),
                updatedTip.getTitle(),
                updatedTip.getContent(),
                updatedTip.getCategory().getId(),
                tip.getCategory().getName());
    }

    public void deleteRecyclingTip(Long id) {
        RecyclingTip tip = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recycling Tip not found with id: " + id));
        repository.delete(tip);
    }

}
