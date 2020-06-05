package com.ces.corporateemployeesuite.repository;

import com.ces.corporateemployeesuite.entity.HealthIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 6/3/2020.
 */
@Repository
public interface HealthIndexRepository extends JpaRepository<HealthIndex, String> {
}
