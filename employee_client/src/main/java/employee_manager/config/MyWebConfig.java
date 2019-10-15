package employee_manager.config;

import employee.EmployeeService;
import employee.EmployeeServiceService;
import employee.EmployeeServiceServiceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.rpc.ServiceException;

@Configuration
public class MyWebConfig {
    @Bean
    EmployeeService employeeService() throws ServiceException {
        return new EmployeeServiceServiceLocator().getEmployeeServicePort();
    }
}
