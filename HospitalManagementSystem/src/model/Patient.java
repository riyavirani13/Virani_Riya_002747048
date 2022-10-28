/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import data.EncounterHistory;
import java.util.Date;

/**
 *
 * @author riyavirani
 */
public class Patient extends Person{
    private int patientId;
    private EncounterHistory encounterHistory;

    public Patient(int patientId, EncounterHistory encounterHistory, String fullName, House residence, String gender, Date dob, int age, String username, String passsword, String role, int personId) {
        super(fullName, residence, gender, dob, age, username, passsword, role, personId);
        this.patientId = patientId;
        this.encounterHistory = encounterHistory;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public EncounterHistory getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
    
    
}
