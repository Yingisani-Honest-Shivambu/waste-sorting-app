package com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory,Long> {

}
