package com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByCategoryId(Long categoryId);
}
