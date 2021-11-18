package com.tjordan.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjordan.dao.employee.Employee;
import com.tjordan.service.EmployeeService;
import com.tjordan.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EmployeeDelegate {

    private final ObjectMapper mapper =new ObjectMapper();

    public void getAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> allEmployees = EmployeeService.getEmployeeService().getAllEmployees();
        resp.setContentType("application/json");
        resp.getWriter().append(mapper.writeValueAsString(allEmployees));
    }

    public void updateProfile(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        //Get the current session/employee.
        HttpSession session = req.getSession();

        Employee currentEmployee = (Employee) session.getAttribute("currentEmployee");

        int id = currentEmployee.getId();

        String userName = currentEmployee.getUserName();
        String sessionPassword = currentEmployee.getPassword();

        //Get values from the submitted form.
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String inputPassword = req.getParameter("password");
        String password = "";

        //Compare new password with previous password.

        //If NOT the same then add.
        if(!(inputPassword.equals(sessionPassword))) {
            //Encrypt the new password
            password = MD5.getMd5(inputPassword);
        } else {
            password = sessionPassword;
        }

        //Call update method and pass in parameters
        Employee updatedEmp = EmployeeService.getEmployeeService().updateEmployee(id,firstName, userName, lastName, email, password);

        //Update Session variable
        session.setAttribute("currentEmployee", updatedEmp);

        //Check if manager or employee.
        currentEmployee = (Employee) session.getAttribute("currentEmployee");
        if(currentEmployee.isManager()) {
            req.getRequestDispatcher("static/Managerindex.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("static/EmployeeIndex.jsp").forward(req,resp);
        }
    }
}
