/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Hospital;

/**
 *
 * @author riyavirani
 */
public class HospitalDirectory {
    private ArrayList<Hospital> hospitalList;

    public HospitalDirectory(ArrayList<Hospital> hospital) {
        this.hospitalList = hospital;
    }

    public HospitalDirectory() {
        this.hospitalList = new ArrayList<Hospital>();
    }

    public ArrayList<Hospital> getHospital() {
        return hospitalList;
    }

    public void setHospital(ArrayList<Hospital> hospital) {
        this.hospitalList = hospital;
    }

    public void addHospital(Hospital hosp) {
        hospitalList.add(hosp);
    }

    public void removeHospital(Hospital hosp) {
        hospitalList.remove(hosp);
    }
    
}
