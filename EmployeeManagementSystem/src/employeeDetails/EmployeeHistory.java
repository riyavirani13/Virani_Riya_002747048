/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeeDetails;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author riyavirani
 */
public class EmployeeHistory {
    private ArrayList<Employee> employeeHistory;
    
    public EmployeeHistory(){
        this.employeeHistory = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeHistory() {
        return employeeHistory;
    }

    public void setEmployeeHistory(ArrayList<Employee> employeeHistory) {
        this.employeeHistory = employeeHistory;
    }
    
    public boolean addNewEmployee(Employee e){
        //Employee newEmployee = new Employee();
        //boolean bName = Pattern.matches("^[A-Za-z0-9]*$", e.getName());
        //boolean bPhone = Pattern.matches("[0-9]{10}", e.getContactDetails().keySet().toString().replaceAll("[\\[\\],]", ""));
        //boolean bAge = Pattern.matches("[0-9]", Integer.toString(e.getAge()));
        /*boolean b=false;
        if(findEmployee(e.getEmployeeId())==null){
            boolean bName = Pattern.matches("^[A-Za-z0-9]*$", e.getName());
            if(bName){
                boolean bPhone = Pattern.matches("[0-9]{10}", e.getContactDetails().keySet().toString().replaceAll("[\\[\\],]", ""));
                if(bPhone){
                    boolean bAge = Pattern.matches("[0-9]", Integer.toString(e.getAge()));
                    employeeHistory.add(e);
                    b=true;
                }
            }
        }
        else 
            b=false;
        
        return b;*/
        if(findEmployee(e.getEmployeeId())==null){
            employeeHistory.add(e);
            return true;
        }
        else
            return false;
    }
    
    public Employee findEmployee(int empId){
        for(Employee e : employeeHistory){
            if(e.getEmployeeId()==empId){
                return e;
            }
        }
        return null;
    }
    

    /*public void deleteEmployee(Employee selectedEmployee) {
        employeeHistory.remove(selectedEmployee);
    }*/
    
    public void deleteEmployee(int selectedEmployeeId) {
        Employee emp1 = new Employee();
        for(Employee employee : employeeHistory){
            if(employee.getEmployeeId()==selectedEmployeeId){
                emp1=employee;
                break;
            }
        }
        employeeHistory.remove(emp1);
    }

    
    
}
