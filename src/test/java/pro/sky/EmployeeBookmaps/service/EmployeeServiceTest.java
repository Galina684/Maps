package pro.sky.EmployeeBookmaps.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.EmployeeBookmaps.employees.Employee;

import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService out= new EmployeeService();

    static Stream<Arguments> arguments() {
        return Stream.of(Arguments.of("Ivan", "Ivanov", 5, 1000),
                Arguments.of("Petr", "Sidorov", 1, 1500),
                Arguments.of("Anna", "Petrova", 1, 1100));
    }

    @ParameterizedTest
   @MethodSource("arguments")
    void addTest(String firstName, String lastName, int departmentId,
             Integer salary) {
Employee employeesAdd = out.addEmployee(firstName,lastName,departmentId,salary);
        assertNotNull(employeesAdd);
        assertEquals(firstName, employeesAdd.getFirstName());
        assertEquals(lastName, employeesAdd.getLastName());
        assertEquals(salary, employeesAdd.getSalary());
        assertEquals(departmentId, employeesAdd.getDepartmentId());
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void removeTest(String firstName, String lastName, int departmentId,
                    Integer salary) {
        Employee employeesAdd = out.addEmployee(firstName,lastName,departmentId,salary);
        Employee employeeRemove = out.removeEmployee(firstName,lastName,departmentId,salary);
        assertNotNull(employeeRemove);
        assertEquals(firstName, employeeRemove.getFirstName());
        assertEquals(lastName, employeeRemove.getLastName());

    }

    @ParameterizedTest
    @MethodSource("arguments")
    void findTest(String firstName, String lastName, int departmentId,
                  Integer salary) {
        Employee employeesAdd = out.addEmployee(firstName,lastName,departmentId,salary);
        Employee employeesFind = out.findEmployee(firstName,lastName,departmentId,salary);
        assertNotNull(employeesFind);
        assertEquals(firstName, employeesFind.getFirstName());
        assertEquals(lastName, employeesFind.getLastName());
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void findAllTest(String firstName, String lastName, int departmentId,
                     Integer salary) {
        Employee employeesAdd = out.addEmployee(firstName,lastName,departmentId,salary);
        Collection<Employee> employeeCollection = out.findAll();
        assertTrue(employeeCollection.contains(employeesAdd));
    }

}