/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import model.Person;

/**
 *
 * @author riyavirani
 */
public class PersonDirectory {
    private ArrayList<Person> personList;

    public PersonDirectory() {
        this.personList = new ArrayList<Person>();
    }

    
    public void addPerson(Person person){
        personList.add(person);
    }
    
    public void removePerson(Person person){
        personList.remove(person);
    }
    
    public String login(String username, String password){
        for(Person p:this.personList){
            if(p.getUsername().equals(username) && p.getPassword().equals(password)){
                return p.getRole();
            }
        }
        return "Null";
    }
    
    public String getCommunityNameOfSelectedPatient(String username, String password){
        for(Person p:this.personList){
            if(p.getUsername().equals(username) && p.getPassword().equals(password)){
                return p.getResidence().getCommunityName();
            }
        }
        return "Null";
    }
    
    
    
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public boolean checkDuplicateUsername(String username) {
        for(Person p:personList){
            if(username.equals(p.getUsername())){
                return true;
            }
        }
        return false;
    }

    
    
}
