/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author riyavirani
 */
public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String communityName;

    public Hospital(int hospitalId, String hospitalName, String communityName) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.communityName = communityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    
    @Override
    public String toString(){
        return hospitalName;
    }
    
    
}
