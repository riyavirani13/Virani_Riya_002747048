/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author riyavirani
 */
public class DoctorDirectory {
    private ArrayList<Doctor> doctorList;

    public DoctorDirectory(ArrayList<Doctor> doctors) {
        this.doctorList = doctors;
    }

    public DoctorDirectory() {
        this.doctorList = new ArrayList<Doctor>();
    }

    public ArrayList<Doctor> getDoctor() {
        return doctorList;
    }

    public void setDoctor(ArrayList<Doctor> doctor) {
        this.doctorList = doctor;
    }

    
    
}
