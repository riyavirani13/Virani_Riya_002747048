/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Patient;
import model.Person;

/**
 *
 * @author riyavirani
 */
public class PatientDirectory {
    private ArrayList<Patient> patientList; 

    public PatientDirectory(ArrayList<Patient> patients) {
        this.patientList = patients;
    }

    public PatientDirectory() {
        this.patientList = new ArrayList<Patient>();
        
    }
    
    public Patient getCurrentPatient(String username, String password){
        for(Patient p:this.patientList){
            if(p.getUsername().equals(username) && p.getPassword().equals(password)){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Patient> getPatient() {
        return patientList;
    }

    public void setPatient(ArrayList<Patient> patient) {
        this.patientList = patient;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }
    
    public void removePatient(Patient patient) {
        patientList.remove(patient);
    }
    
}
