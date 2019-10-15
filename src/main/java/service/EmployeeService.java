package service;

import entity.Employees;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService()
public class EmployeeService {
    @WebMethod
    public String addEmployees(Employees employees) {
        final Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(employees);
            transaction.commit();
            return "save success!";
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return "save fail!";
        } finally {
            session.close();
        }
    }

    @WebMethod
    public List<Employees> getEmployees() {
        List<Employees> employees = HibernateUtil.getSession().createQuery("from Employees", Employees.class).list();
        return employees;
    }

    @WebMethod
    public Employees updateEmployees(long id, Employees employee) {
        Employees e = HibernateUtil.getSession().get(Employees.class, id);
        if (e != null) {
            e.setName(employee.getName());
            e.setSalary(employee.getSalary());
            return e;
        } else
            return null;
    }

    @WebMethod
    public Employees getE(long id) {
        Employees e = HibernateUtil.getSession().get(Employees.class, id);
        if (e == null)
            return null;
        else
            return e;
    }
}
