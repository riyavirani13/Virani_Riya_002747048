/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import data.HospitalDirectory;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */
public class City {
    private String cityName;
    int cityId;
    private ArrayList<Community> community;

    public City(String cityName, int cityId, ArrayList<Community> community) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.community = community;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public ArrayList<Community> getCommunity() {
        return community;
    }

    public void setCommunity(ArrayList<Community> community) {
        this.community = community;
    }

    
    
}
