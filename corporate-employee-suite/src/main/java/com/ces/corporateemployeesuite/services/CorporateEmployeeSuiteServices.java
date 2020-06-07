package com.ces.corporateemployeesuite.services;

import com.ces.corporateemployeesuite.entity.HealthIndex;
import com.ces.corporateemployeesuite.entity.Seat;
import com.ces.corporateemployeesuite.repository.HealthIndexRepository;
import com.ces.corporateemployeesuite.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 6/5/2020.
 */
@Service
public class CorporateEmployeeSuiteServices  {

    @Value("${maximum.temparature}")
    private Integer maxTemp;

    @Value("${spo2.required.minimum.level}")
    private Integer spo2Level;

    @Value("${blood.pressure.range}")
    private String bpRange;

    @Autowired
    private HealthIndexRepository healthIndexRepository;

    @Autowired
    private SeatRepository seatRepository;
    public HealthIndex evaluateHeathStatus(HealthIndex healthData) {

        healthData.setStatus(getHealthStatus(healthData));
        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        healthData.setLastUpdatedDate(ts);
        return healthIndexRepository.save(healthData);
    }

    private String getHealthStatus(HealthIndex healthData) {
        List<String> ranges = Arrays.asList(bpRange.split("-"));
        int highestLevel = Integer.parseInt(ranges.get(1));
        int lowestLevel = Integer.parseInt(ranges.get(0));
        String status = null;
        if((Integer.parseInt(healthData.getTemparature()) < maxTemp) && !healthData.getDryCough() && !healthData.getHeadache()
                && (healthData.getBloodPressure() > lowestLevel && (healthData.getBloodPressure() < highestLevel)) && healthData.getSpo2() > spo2Level) {
            status = "green";
        } else if ((Integer.parseInt(healthData.getTemparature()) >= maxTemp) && healthData.getDryCough() && healthData.getHeadache()
                && (healthData.getBloodPressure() < lowestLevel || (healthData.getBloodPressure() > highestLevel)) && healthData.getSpo2() < spo2Level){
            status = "red";
        } else {
            status = "yellow";
        }
        return status;
    }

    public List<Seat> getAllAvailableSeats(String floor, String section) {
        return seatRepository.findByFloorandSection(floor, section);
    }
}
