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
    private Encounter encounter;
    private int hospitalId;

    public Patient(int patientId, EncounterHistory encounterHistory, Encounter encounter, String fullName, House residence, String gender, String dob, int age, String username, String passsword, String role/*, int personId*/) {
        super(fullName, residence, gender, dob, age, username, passsword, role/*, personId*/);
        this.patientId = patientId;
        this.encounterHistory = encounterHistory;
        this.encounter = encounter;
        this.hospitalId = 0;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
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
    
    @Override
    public String toString(){
        return this.getFullName();
    }

    public void addEncounterHistory(Encounter encounter) {
        encounterHistory.getEncounter().add(encounter);
    }
    
}
