package com.enviro.assessment.grad001.YingisaniHonestShivambu.services;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTipDTO> getAllRecyclingTips(){
        return repository.findAll().stream()
                .map(tip -> new RecyclingTipDTO(
                        tip.getId(),
                        tip.getTitle(),
                        tip.getContent(),
                        tip.getCategory().getId(),
                        tip.getCategory().getName()
                )).collect(Collectors.toList());
    }

    public List<RecyclingTipDTO>  getRecyclingTipsByCategory(Long categoryId){
        return repository.findByCategoryId(categoryId).stream()
                .map(tip -> new RecyclingTipDTO(
                        tip.getId(),
                        tip.getTitle(),
                        tip.getContent(),
                        tip.getCategory().getId(),
                        tip.getCategory().getName()
                )).collect(Collectors.toList());
    }

}
