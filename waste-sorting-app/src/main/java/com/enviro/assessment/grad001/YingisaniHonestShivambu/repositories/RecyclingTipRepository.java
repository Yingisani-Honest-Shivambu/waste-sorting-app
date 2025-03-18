package com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for RecyclingTip.
 * Extends JpaRepository to provide built-in CRUD operations.
 */
@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    /**
     * Finds all recycling tips associated with a specific waste category.
     * @param categoryId The ID of the waste category.
     * @return A list of recycling tips linked to the given category.
     */
    List<RecyclingTip> findByCategoryId(Long categoryId);

}
