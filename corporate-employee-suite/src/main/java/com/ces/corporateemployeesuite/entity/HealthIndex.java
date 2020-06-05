package com.ces.corporateemployeesuite.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


/**
 * Created by dell on 6/3/2020.
 */
@Entity
@Table(name = "HEALTHINDEX")
public class HealthIndex {
    @Id
    private String UserName;
    private String First_Name;
    private String Last_Name;
    private String Temparature;
    private Boolean DryCough;
    private Integer BloodPressure;
    private Boolean Headache ;
    private String Status ;
    private Timestamp LastUpdatedDate;
    private Integer Spo2;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getTemparature() {
        return Temparature;
    }

    public void setTemparature(String temparature) {
        Temparature = temparature;
    }

    public Boolean getDryCough() {
        return DryCough;
    }

    public void setDryCough(Boolean dryCough) {
        DryCough = dryCough;
    }

    public Integer getBloodPressure() {
        return BloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        BloodPressure = bloodPressure;
    }

    public Boolean getHeadache() {
        return Headache;
    }

    public void setHeadache(Boolean headache) {
        Headache = headache;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Timestamp getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }

    public Integer getSpo2() {
        return Spo2;
    }

    public void setSpo2(Integer spo2) {
        Spo2 = spo2;
    }

    @Override
    public String toString() {
        return "HealthIndex{" +
                "UserName='" + UserName + '\'' +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Temparature='" + Temparature + '\'' +
                ", DryCough=" + DryCough +
                ", BloodPressure=" + BloodPressure +
                ", Headache=" + Headache +
                ", Status='" + Status + '\'' +
                ", LastUpdatedDate=" + LastUpdatedDate +
                ", Spo2=" + Spo2 +
                '}';
    }
}
