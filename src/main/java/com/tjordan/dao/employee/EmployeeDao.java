package com.tjordan.dao.employee;

import java.util.List;

public interface EmployeeDao {
    public Employee validateLogin(String userName, String password);
    public Employee getEmployee(String userName);
    public boolean checkUser(String userName, String password);
    public Employee updateEmployee(int id, String firstName, String userName, String lastName, String email, String password);
    public List<Employee> getAllEmployees();
    public boolean addEmployee(String userName, String firstName, String lastName, String password, String email, String isManager);

}
