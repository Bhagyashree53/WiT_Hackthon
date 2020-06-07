package com.ces.corporateemployeesuite.services;

import com.ces.corporateemployeesuite.entity.EmployeeSeat;
import com.ces.corporateemployeesuite.entity.HealthIndex;
import com.ces.corporateemployeesuite.entity.Seat;
import com.ces.corporateemployeesuite.repository.EmployeeSeatRepository;
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

    @Autowired
    private EmployeeSeatRepository employeeSeatRepository;

    /**
     * Function to evaluate health status of employee
     * @param healthData
     * @return
     */
    public HealthIndex evaluateHeathStatus(HealthIndex healthData) {

        healthData.setStatus(getHealthStatus(healthData));
        healthData.setLastUpdatedDate(getTimestamp());
        return healthIndexRepository.save(healthData);
    }

    /**
     * Function involves logic for calculating health status
     * @param healthData
     * @return
     */
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

    /**
     * Method to get all seats present in selected area for admin function
     * @param floor
     * @param section
     * @return
     */
    public List<Seat> getAllAvailableSeats(String floor, String section) {
        return seatRepository.findByFloorandSection(floor, section);
    }

    /**
     * Method to get all seats which are available for employee occupancy
     * @param floor
     * @param section
     * @return
     */
    public List<Seat> getAllAvailableSeatsEmployee(String floor, String section) {
        return seatRepository.findSeatsEmployee(floor, section);
    }

    public String updateEmployeeSeat(String floor, String section, String userName) {

        //first check if seat is available
        List<Seat> availableSeats = seatRepository.findSeatsEmployee(floor, section);
        EmployeeSeat empSeat = new EmployeeSeat();
        String status = "No seats available to allocate. Please try next time";
        //check size and if more than 0 then take first and allocate to user
        if(availableSeats.size() > 0) {

            empSeat.setUserName(userName);
            empSeat.setFloor(floor);
            empSeat.setSection(section);
            empSeat.setSeatNumber(availableSeats.get(0).getSeatNumber());
            empSeat.setLogin(getTimestamp());

            //save to EmployeeSeat
            employeeSeatRepository.save(empSeat);

            //Make UserAlloted to 1 in Seat
            Seat seat = availableSeats.get(0);
            seat.setUserAllocated(true);
            seatRepository.save(seat);

            status = "Seat "+seat.getSeatNumber()+" has been allocated to "+userName;
        }
        return status;

    }

    public Timestamp getTimestamp () {

        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        return  ts;
    }
    
    public boolean updateAvailableSeats(@RequestParam List<Seat> seats) {
        boolean result=true;
        for ( Seat seat :seats)
        {
            result=seatRepository.updateSeatAllocation(seat.getId(), seat.isUserAllocated());
        }
        return result;
    }
}

