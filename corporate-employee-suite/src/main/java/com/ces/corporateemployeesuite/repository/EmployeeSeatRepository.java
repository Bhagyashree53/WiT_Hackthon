package com.ces.corporateemployeesuite.repository;

import com.ces.corporateemployeesuite.entity.EmployeeSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 6/7/2020.
 */
@Repository
public interface EmployeeSeatRepository extends JpaRepository<EmployeeSeat, Integer> {
}
