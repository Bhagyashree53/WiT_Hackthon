package com.ces.corporateemployeesuite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by dell on 6/6/2020.
 */
@Entity
@Table(name = "EMPLOYEESEAT")
public class EmployeeSeat {

    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String Floor ;
    private String Section ;
    private String SeatNumber ;
    private Timestamp login;
    private Timestamp logout;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public Timestamp getLogin() {
        return login;
    }

    public void setLogin(Timestamp login) {
        this.login = login;
    }

    public Timestamp getLogout() {
        return logout;
    }

    public void setLogout(Timestamp logout) {
        this.logout = logout;
    }

    @Override
    public String toString() {
        return "EmployeeSeat{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", Floor='" + Floor + '\'' +
                ", Section='" + Section + '\'' +
                ", SeatNumber='" + SeatNumber + '\'' +
                ", login=" + login +
                ", logout=" + logout +
                '}';
    }
}
