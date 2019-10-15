package example;
import service.EmployeeService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class HelloWorld {

  public static void main(String[] argv) {

    String address = "http://localhost:9000/employee";
    Endpoint.publish(address, new EmployeeService());
  }
}
