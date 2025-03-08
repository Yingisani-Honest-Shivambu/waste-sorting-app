package com.enviro.assessment.grad001.YingisaniHonestShivambu.services;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.WasteCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;
    public List<WasteCategoryDTO> getAllWasteCategories(){
        return repository.findAll().stream()
                .map(category -> new WasteCategoryDTO(
                        category.getId(),
                        category.getName(),
                        category.getGuidelines().size(),
                        category.getTips().size()))
                .collect(Collectors.toList());
    }

    public WasteCategoryDTO getWasteCategoryById(Long id){
        WasteCategory category = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Waste Category was not found with id: "+id));
        return new WasteCategoryDTO(
                category.getId(),
                category.getName(),
                category.getGuidelines().size(),
                category.getTips().size());
    }

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

    public WasteCategory updateWasteCategory(Long id,WasteCategory updatedCategory){
        WasteCategory category  = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Waste Category was not found with id: "+id));
        category.setName(updatedCategory.getName());
        return repository.save(category);
    }

    public void deleteWasteCategory(Long id){
        repository.deleteById(id);
    }
}
