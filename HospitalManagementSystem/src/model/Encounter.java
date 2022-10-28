/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author riyavirani
 */
public class Encounter {
    private Date aptDate;
    private String diagnosis;
    private VitalSigns vitalSign;

    public Encounter(Date aptDate, String diagnosis, VitalSigns vitalSign) {
        this.aptDate = aptDate;
        this.diagnosis = diagnosis;
        this.vitalSign = vitalSign;
    }

    public Date getAptDate() {
        return aptDate;
    }

    public void setAptDate(Date aptDate) {
        this.aptDate = aptDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public VitalSigns getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(VitalSigns vitalSign) {
        this.vitalSign = vitalSign;
    }
    
}
