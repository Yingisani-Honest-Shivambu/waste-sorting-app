package com.enviro.assessment.grad001.YingisaniHonestShivambu.repositories;

import com.enviro.assessment.grad001.YingisaniHonestShivambu.models.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    List<RecyclingTip> findByCategoryId(Long categoryId);

}
