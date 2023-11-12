package pro.sky.EmployeeBookmaps.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeBookmaps.employees.Employee;
import pro.sky.EmployeeBookmaps.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeBookmaps.exception.EmployeeDataRecordedIncorrectly;
import pro.sky.EmployeeBookmaps.exception.EmployeeNotFoundException;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final Map<String, Employee> employees;

    @Autowired
    public EmployeeService() {
        this.employees = new HashMap<>();
    }



    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId,
                                Integer salary) {
        chekingTheCorrectName(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName, int departmentId,
                                   Integer salary) {
        chekingTheCorrectName(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int departmentId,
                                 Integer salary) {
        chekingTheCorrectName(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

    @Override
    public Collection<Employee> findAll() {
        return this.employees.values();
    }
    public void chekingTheCorrectName(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new EmployeeDataRecordedIncorrectly();
        }
    }
}
