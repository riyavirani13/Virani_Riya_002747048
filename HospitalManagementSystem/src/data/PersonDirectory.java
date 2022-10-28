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
    private ArrayList<Person> person;

    public PersonDirectory(ArrayList<Person> person) {
        this.person = person;
    }

    public ArrayList<Person> getPerson() {
        return person;
    }

    public void setPerson(ArrayList<Person> person) {
        this.person = person;
    }
    
    
}
