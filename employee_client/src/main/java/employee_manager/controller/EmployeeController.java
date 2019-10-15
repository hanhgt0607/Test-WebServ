package employee_manager.controller;

import employee.EmployeeService;
import employee.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.RemoteException;

@RequestMapping(value = "/employee")
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //getlist
    @RequestMapping(method = RequestMethod.GET)
    public String getList(Model model) throws RemoteException {
        try {
            Employees[] employees = employeeService.getEmployees();
            model.addAttribute("employees", employees);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return "list";
    }

    //create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("employee", new Employees());
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createEmployee(Employees employee) throws RemoteException {
        employeeService.addEmployees(employee);
        return "redirect:/employee";
    }

    //update
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showFormUpdate(Model model, @PathVariable long id) throws RemoteException {
        Employees employee = employeeService.getE(id);
        model.addAttribute("emp", employee);
        return "update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateEmployee(Employees employee, @PathVariable long id) throws RemoteException {
        employeeService.updateEmployees(id, employee);
        return "redirect:/employee";
    }
}