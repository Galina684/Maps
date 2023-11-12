package pro.sky.EmployeeBookmaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeBookmaps.employees.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    private final EmployeeServiceInterface employeeServiceInterface;

    @Autowired
    public DepartmentService(EmployeeServiceInterface employeeServiceInterface) {
        this.employeeServiceInterface = employeeServiceInterface;
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return employeeServiceInterface.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Сотрудник не найден"));
    }

    @Override
    public Employee minSalary(int departmentId) {
        return employeeServiceInterface.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Сотрудник не найден"));
    }

    @Override
    public Map<Integer, List<Employee>> employeesByDepartment(int departmentId) {
        return employeeServiceInterface.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public Map<Integer, List<Employee>> allEmployees() {
        return employeeServiceInterface.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}
