package com.ces.corporateemployeesuite.controller;

import com.ces.corporateemployeesuite.entity.HealthIndex;
import com.ces.corporateemployeesuite.services.CorporateEmployeeSuiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 6/5/2020.
 */
@RestController
public class CorporateEmployeeSuiteController {

    @Autowired
    private CorporateEmployeeSuiteServices corporateEmployeeSuiteServices;
    @PostMapping("/healthIndex")
    public HealthIndex newEmployee(@RequestBody HealthIndex healthData) {
        System.out.print(healthData);
        return corporateEmployeeSuiteServices.evaluateHeathStatus(healthData);
    }
}
