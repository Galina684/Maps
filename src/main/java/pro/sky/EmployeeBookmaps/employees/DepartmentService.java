package pro.sky.EmployeeBookmaps.employees;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeBookmaps.exception.EmployeeAlreadyAddedException;

import java.util.*;

@Service
public class DepartmentService implements DepartmentServiceInterface{

    List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName, int departmentId, Integer salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee maxSalary(int departmentId){

        Optional<Employee> maxSalary = employees.stream()
                .filter(employees -> employees.getDepartmentId()==(departmentId))

                .max(Comparator.comparingInt(employees -> employees.getSalary()));

        return maxSalary.orElse(null);

    }

@Override
    public Employee minSalary(int departmentId){
        Optional<Employee> minSalary = employees.stream()
                .filter(employees -> employees.getDepartmentId()==(departmentId))

                .min(Comparator.comparingInt(employees -> employees.getSalary()));

        return minSalary.orElse(null);

    }

}
