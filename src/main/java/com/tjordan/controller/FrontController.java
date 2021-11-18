package com.tjordan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjordan.dispatcher.Dispatcher;
import org.apache.catalina.servlets.DefaultServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends DefaultServlet {

    private static final long serialVersionUID = 1L;

    private Dispatcher dispatch = new Dispatcher();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((req.getRequestURI().equals("/Project1ERS/")) || (req.getRequestURI().contains("/static")) || req.getRequestURI().contains("index")) {
            super.doGet(req,resp);
        } else {
            dispatch.process(req, resp);
        }
    }
    // This prob should NOT be done this way.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }






}
