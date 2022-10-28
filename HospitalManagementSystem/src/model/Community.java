/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */
public class Community {
    private String communityName;
    private String communityId;
    private ArrayList<House> house;
    private ArrayList<Hospital> hospital;

    public Community(String communityName, String communityId, ArrayList<House> house, ArrayList<Hospital> hospital) {
        this.communityName = communityName;
        this.communityId = communityId;
        this.house = house;
        this.hospital = hospital;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public ArrayList<House> getHouse() {
        return house;
    }

    public void setHouse(ArrayList<House> house) {
        this.house = house;
    }

    public ArrayList<Hospital> getHospital() {
        return hospital;
    }

    public void setHospital(ArrayList<Hospital> hospital) {
        this.hospital = hospital;
    }
    
    
    
}
