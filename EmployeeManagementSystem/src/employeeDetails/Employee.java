/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeeDetails;

import java.awt.Image;
import java.util.Date;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author riyavirani
 */
public class Employee {
    private String name;
    private int employeeId;
    private int age;
    private String gender;
    private String startDate;
    private String level;
    private String teamInfo;
    private String positionTitle;
    private Map<Long,String> contactDetails;
    /*private long phoneNumber;
    private String emailAddress;*/
    private ImageIcon photo;
    
    public Employee(String name, int employeeId, int age, String gender, String startDate, String level, String teamInfo, String positionTitle, Map<Long,String> contactDetails, ImageIcon photo) {
        this.name = name;
        this.employeeId = employeeId;
        this.age = age;
        this.gender = gender;
        this.startDate = startDate;
        this.level = level;
        this.teamInfo = teamInfo;
        this.positionTitle = positionTitle;
        this.contactDetails = contactDetails;
        this.photo = photo;
    }

    public Employee() {
    }

    public Map<Long, String> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Map<Long, String> contactDetails) {
        this.contactDetails = contactDetails;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    /*public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }*/

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    
    

    @Override
    public String toString(){
        return name;
    }
    
    
}
