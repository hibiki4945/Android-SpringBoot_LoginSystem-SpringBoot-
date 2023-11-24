package com.example.okHttp_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holiday_acquire_sequence")
public class HolidayAcquireSequence {
    
    @Id
    @Column(name = "ID_NUMBER")
    private int idNumber;

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public HolidayAcquireSequence() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HolidayAcquireSequence(int idNumber) {
        super();
        this.idNumber = idNumber;
    }
    
}
