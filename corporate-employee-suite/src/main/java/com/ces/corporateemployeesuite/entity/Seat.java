package com.ces.corporateemployeesuite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dell on 6/6/2020.
 */
@Entity
@Table(name = "SEAT")
public class Seat {

    @Id
    @GeneratedValue
    private Integer id;
    private String Floor ;
    private String Section ;
    private String SeatNumber ;
    private boolean AdminOpened ;
    private boolean UserAllocated ;


    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        SeatNumber = seatNumber;
    }

    public boolean isAdminOpened() {
        return AdminOpened;
    }

    public void setAdminOpened(boolean adminOpened) {
        AdminOpened = adminOpened;
    }

    public boolean isUserAllocated() {
        return UserAllocated;
    }

    public void setUserAllocated(boolean userAllocated) {
        UserAllocated = userAllocated;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "Floor='" + Floor + '\'' +
                ", Section='" + Section + '\'' +
                ", SeatNumber='" + SeatNumber + '\'' +
                ", AdminOpened=" + AdminOpened +
                ", UserAllocated=" + UserAllocated +
                '}';
    }
}
