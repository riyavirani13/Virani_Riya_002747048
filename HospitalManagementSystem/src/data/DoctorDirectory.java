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

    public void addDoctor(Doctor d) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        doctorList.add(d);
    }

    public void removeDoctor(Doctor d) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        doctorList.remove(d);
    }

    
    public Doctor getCurrentDoctor(String username, String password){
        for(Doctor d:this.doctorList){
            if(d.getUsername().equals(username) && d.getPassword().equals(password)){
                return d;
            }
        }
        return null;
    }
    
    
}
