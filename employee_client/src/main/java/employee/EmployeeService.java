/**
 * EmployeeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package employee;

public interface EmployeeService extends java.rmi.Remote {
    public employee.Employees updateEmployees(long arg0, employee.Employees arg1) throws java.rmi.RemoteException;
    public employee.Employees[] getEmployees() throws java.rmi.RemoteException;
    public employee.Employees getE(long arg0) throws java.rmi.RemoteException;
    public java.lang.String addEmployees(employee.Employees arg0) throws java.rmi.RemoteException;
}
