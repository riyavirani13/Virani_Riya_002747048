/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.City;
import model.Hospital;
import model.Patient;

/**
 *
 * @author riyavirani
 */
public class HospitalDirectory {
    private ArrayList<Hospital> hospital;

    public HospitalDirectory(ArrayList<Hospital> hospital) {
        this.hospital = hospital;
    }

    public ArrayList<Hospital> getHospital() {
        return hospital;
    }

    public void setHospital(ArrayList<Hospital> hospital) {
        this.hospital = hospital;
    }

    
}
