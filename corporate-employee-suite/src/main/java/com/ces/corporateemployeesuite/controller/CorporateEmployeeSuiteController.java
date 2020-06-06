package com.ces.corporateemployeesuite.controller;

import com.ces.corporateemployeesuite.entity.HealthIndex;
import com.ces.corporateemployeesuite.entity.Seat;
import com.ces.corporateemployeesuite.services.CorporateEmployeeSuiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dell on 6/5/2020.
 */
@RestController
public class CorporateEmployeeSuiteController {

    @Autowired
    private CorporateEmployeeSuiteServices corporateEmployeeSuiteServices;
    @PostMapping("/healthIndex")
    public HealthIndex evaluateHealthStatus(@RequestBody HealthIndex healthData) {
        System.out.print(healthData);
        return corporateEmployeeSuiteServices.evaluateHeathStatus(healthData);
    }

    @GetMapping("/getAllAvailableSeats")
    public List<Seat> getAllAvailableSeats(@RequestParam String floor, @RequestParam String section) {
        List<Seat> seats = corporateEmployeeSuiteServices.getAllAvailableSeats(floor, section);
        return seats;
    }
}
