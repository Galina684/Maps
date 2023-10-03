package pro.sky.EmployeeBookmaps.employees;

import java.util.Collection;
import java.util.Map;

public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName, int departmentId,
                 Integer salary);
    Employee remove(String firstName, String lastName, int departmentId,
                    Integer salary);
    Employee find(String firstName, String lastName, int departmentId,
                  Integer salary);
    Map<String, Employee> findAll();
}
