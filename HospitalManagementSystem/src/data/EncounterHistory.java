/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Encounter;
import model.Patient;

/**
 *
 * @author riyavirani
 */
public class EncounterHistory {
    private ArrayList<Encounter> encounter;

    public EncounterHistory(ArrayList<Encounter> encounter) {
        this.encounter = encounter;
    }

    public ArrayList<Encounter> getEncounter() {
        return encounter;
    }

    public void setEncounter(ArrayList<Encounter> encounter) {
        this.encounter = encounter;
    }

    
}
