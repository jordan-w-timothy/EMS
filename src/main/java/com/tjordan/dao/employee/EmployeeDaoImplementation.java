package com.tjordan.dao.employee;

import java.util.logging.Logger;

public class EmployeeDaoImplementation implements EmployeeDao {

    private static EmployeeDaoImplementation EmployeeDao;
    //final static Logger EmployeeLog = Logger.getLogger(EmployeeDaoImplementation.class);

    private EmployeeDaoImplementation(){

    }

    public static EmployeeDaoImplementation getEmployeeDao() {
        if(EmployeeDao == null) {
            EmployeeDao = new EmployeeDaoImplementation();
        }

        return EmployeeDao;
    }

    
}
