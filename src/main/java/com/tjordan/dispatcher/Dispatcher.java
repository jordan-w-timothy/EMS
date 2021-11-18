package com.tjordan.dispatcher;

import com.tjordan.dao.employee.Employee;
import com.tjordan.delegate.EmployeeDelegate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Dispatcher {

    //Create Delegates
    private static EmployeeDelegate ed = new EmployeeDelegate();

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Employee currentEmployee = (Employee)session.getAttribute("currentEmployee");
        String switchString = req.getRequestURI().substring(req.getContextPath().length()+1);
        //Why do it this way?
        while(switchString.indexOf("/")>0) {
            switchString = switchString.substring(0, switchString.indexOf("/"));
        }

        switch(switchString) {
            case "updateReq":
                break;
            case "AllRequest":
                break;
            case "getGResolved":
                break;
            case "getAllPending":
                break;
            case "addEmployee":
                break;
            case "allUsers":
                break;
            case "updateProfile":
                break;
            case "addRequest":
                break;
            case "getResolved":
                break;
            case "getPending":
                break;
            case "info":
                break;
            case "returnHome":
                break;
            case "editProfile":
                break;
            case "profileView":
                break;
            case "manHome":
                break;
            case "empHome":
                break;
            case "login":
                break;
            case "logout":
                break;
            default:
                break;


        }
    }
}
