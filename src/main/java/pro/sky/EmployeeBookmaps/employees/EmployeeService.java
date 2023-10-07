package pro.sky.EmployeeBookmaps.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeBookmaps.exception.EmployeeAlreadyAddedException;
import pro.sky.EmployeeBookmaps.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final Map<String, Employee> employees;
@Autowired
    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int departmentId,
     Integer salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int departmentId,
                           Integer salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int departmentId,
                         Integer salary) {
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
}
