/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author riyavirani
 */
public class Doctor extends Person {
    private int doctorId;
    private int hospitalId;
    //private ArrayList<VitalSigns> vitalSigns;

    public Doctor(int doctorId, int hospitalId, /*ArrayList<VitalSigns> vitalSigns,*/ String fullName, House residence, String gender, String dob, int age, String username, String passsword, String role/*, int personId*/) {
        super(fullName, residence, gender, dob, age, username, passsword, role/*, personId*/);
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
        //this.vitalSigns = vitalSigns;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    /*
    public ArrayList<VitalSigns> getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(ArrayList<VitalSigns> vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
    */
    
    
    
}
