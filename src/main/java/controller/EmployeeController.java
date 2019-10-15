package controller;

import service.EmployeeService;

import javax.xml.ws.Endpoint;

public class EmployeeController {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9000/employee", new EmployeeService());
    }
}
