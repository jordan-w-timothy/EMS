package com.tjordan.dao.employee;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeDaoImplementation implements EmployeeDao {

    private static EmployeeDaoImplementation EmployeeDao;
    //final static Logger EmployeeLog = Logger.getLogger(EmployeeDaoImplementation.class);

    private EmployeeDaoImplementation(){

    }
    //What is this used for?
    public static EmployeeDaoImplementation getEmployeeDao() {
        if(EmployeeDao == null) {
            EmployeeDao = new EmployeeDaoImplementation();
        }

        return EmployeeDao;
    }

    //ValidateLogin Implementation
    public Employee validateLogin(String userName, String password) {
        Employee tempEmployee = null;
        return null;
    }

    //getEmployee Implementation
    public Employee getEmployee(String userName) {
        return null;
    }

    //checkUser Implementation
    public boolean checkUser(String userName, String password) {
        return false;
    }

    //updateEmployee Implementation
    public Employee updateEmployee (int id, String firstName, String userName, String lastname, String email, String password) {
        return null;
    }
    //getAllEmployees implementation
    public List<Employee> getAllEmployees() {
        return null;
    }

    //addEmployee implementation
    public boolean addEmployee(String userName, String firstName, String lastName, String password, String email, boolean isManager) {
        return false;
    }


}
