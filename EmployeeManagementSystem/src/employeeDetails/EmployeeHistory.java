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
