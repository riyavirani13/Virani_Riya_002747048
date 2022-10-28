/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Patient;

/**
 *
 * @author riyavirani
 */
public class PatientDirectory {
    private ArrayList<Patient> patient; 

    public PatientDirectory(ArrayList<Patient> patients) {
        this.patient = patients;
    }

    public ArrayList<Patient> getPatient() {
        return patient;
    }

    public void setPatient(ArrayList<Patient> patient) {
        this.patient = patient;
    }
    
    
}
