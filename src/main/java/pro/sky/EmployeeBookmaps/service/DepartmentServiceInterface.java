package pro.sky.EmployeeBookmaps.service;

import pro.sky.EmployeeBookmaps.employees.Employee;

import java.util.List;
import java.util.Map;


public interface DepartmentServiceInterface {


    Employee minSalary(int departmentId);

    Employee maxSalary(int departmentId);

    Map<Integer, List<Employee>> employeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> allEmployees();
}
