package com.ces.corporateemployeesuite.repository;

import com.ces.corporateemployeesuite.entity.EmployeeSeat;
import com.ces.corporateemployeesuite.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dell on 6/6/2020.
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    @Query("SELECT e from Seat e where e.Floor =:Floor and e.Section = :Section")       // using @query
    List<Seat> findByFloorandSection(@Param("Floor") String Floor, @Param("Section") String Section);

    @Query("select e from Seat e where e.Section = :Section and e.Floor = :Floor and e.UserAllocated = 0")
    List<Seat> findSeatsEmployee(@Param("Floor") String Floor, @Param("Section") String Section);
    
    @Query("Update Seat s set s.UserAllocated=:allocation where s.id=:id")
    boolean updateSeatAllocation(@Param("id") int id, @Param("UserAllocated") boolean allocation);

}
