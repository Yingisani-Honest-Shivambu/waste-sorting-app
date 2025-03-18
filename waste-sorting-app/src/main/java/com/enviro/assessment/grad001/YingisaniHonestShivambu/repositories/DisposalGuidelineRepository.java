package com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for DisposalGuideline.
 * Extends JpaRepository to provide built-in CRUD methods.
 */
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    /**
     * Finds all guidelines belonging to a specific waste category.
     */
    List<DisposalGuideline> findByCategoryId(Long categoryId);
}
