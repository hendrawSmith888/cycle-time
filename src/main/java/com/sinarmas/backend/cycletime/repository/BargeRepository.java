package com.sinarmas.backend.cycletime.repository;

import com.sinarmas.backend.cycletime.model.BargeEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: hendraw
 * Description:
 * @Date: 20/07/25
 */
public interface BargeRepository extends JpaRepository<BargeEntitiy, Long> {
}
