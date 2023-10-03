package pro.sky.EmployeeBookmaps.employees;

public interface DepartmentServiceInterface {


    Employee minSalary(int departmentId);

    Employee maxSalary(int departmentId);

    Employee add(String firstName, String lastName, int departmentId, Integer salary);
}
