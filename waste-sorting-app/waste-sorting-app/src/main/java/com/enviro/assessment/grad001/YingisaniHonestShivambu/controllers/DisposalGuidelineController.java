package com.enviro.assessment.grad001.YingisaniHonestShivambu.controllers;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.YingisaniHonestShivambu.services.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wastemanagementapi/guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuidelineDTO> getAllGuidelines(){
        return service.getAllGuidelines();
    }
}
