package pro.sky.EmployeeBookmaps.service;

import pro.sky.EmployeeBookmaps.employees.Employee;

import java.util.Collection;


public interface EmployeeServiceInterface {

    Employee addEmployee(String firstName, String lastName, int departmentId,
                         Integer salary);
    Employee removeEmployee(String firstName, String lastName, int departmentId,
                            Integer salary);
    Employee findEmployee(String firstName, String lastName, int departmentId,
                          Integer salary);
    Collection<Employee> findAll();


}
