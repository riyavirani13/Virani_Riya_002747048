/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeeDetails;

import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */
public class EmployeeHistory {
    private ArrayList<Employee> history;
    
    public EmployeeHistory(){
        this.history = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Employee> history) {
        this.history = history;
    }
    
    public boolean addNewEmployee(Employee e){
        //Employee newEmployee = new Employee();
        if(findEmployee(e.getEmployeeId())==null){
            history.add(e);
            return true;
        }
        else 
            return false;
    }
    
    public Employee findEmployee(int empId){
        for(Employee e : history){
            if(e.getEmployeeId()==empId){
                return e;
            }
        }
        return null;
    }
    

    /*public void deleteEmployee(Employee selectedEmployee) {
        history.remove(selectedEmployee);
    }*/
    
    public void deleteEmployee(int selectedEmployeeId) {
        Employee emp1 = new Employee();
        for(Employee employee : history){
            if(employee.getEmployeeId()==selectedEmployeeId){
                emp1=employee;
                break;
            }
        }
        history.remove(emp1);
    }

    
    
}
