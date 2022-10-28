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
    private ArrayList<Doctor> doctor;

    public DoctorDirectory(ArrayList<Doctor> doctors) {
        this.doctor = doctors;
    }

    public ArrayList<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(ArrayList<Doctor> doctor) {
        this.doctor = doctor;
    }

    
    
}
