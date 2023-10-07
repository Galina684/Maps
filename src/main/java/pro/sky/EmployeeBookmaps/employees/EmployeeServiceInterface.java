package pro.sky.EmployeeBookmaps.employees;

import java.util.Collection;


public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName, int departmentId,
                 Integer salary);
    Employee remove(String firstName, String lastName, int departmentId,
                    Integer salary);
    Employee find(String firstName, String lastName, int departmentId,
                  Integer salary);
    Collection<Employee> findAll();

}
