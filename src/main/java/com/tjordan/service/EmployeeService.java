package com.tjordan.service;

import com.tjordan.dao.employee.Employee;
import com.tjordan.dao.employee.EmployeeDaoImplementation;

import java.util.List;

public class EmployeeService {

    private static EmployeeService currentEmployeeService;

    private EmployeeService() {

    }

    public static EmployeeService getEmployeeService() {
        if(currentEmployeeService == null) {
            currentEmployeeService = new EmployeeService();
        }
        return currentEmployeeService;
    }

    public Employee validateLogin(String userName, String password) {
        return EmployeeDaoImplementation.getEmployeeDao().validateLogin(userName, password);
    }

    public Employee getEmployee(String userName) {
        return EmployeeDaoImplementation.getEmployeeDao().getEmployee(userName);
    }

    public boolean checkUser(String userName, String password) {
        return EmployeeDaoImplementation.getEmployeeDao().checkUser(userName, password);
    }

    public Employee updateEmployee(int id, String firstName, String userName, String lastName, String email, String password) {
        return EmployeeDaoImplementation.getEmployeeDao().updateEmployee(id, firstName, userName, lastName, email, password);
    }

    public List<Employee> getAllEmployees() {
        return EmployeeDaoImplementation.getEmployeeDao().getAllEmployees();
    }

    public boolean addEmployee(String userName, String firstName, String lastname, String password, String email, boolean isManager) {
        return EmployeeDaoImplementation.getEmployeeDao().addEmployee(userName, firstName, lastname, password, email, isManager);
    }

}
