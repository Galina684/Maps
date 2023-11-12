package pro.sky.EmployeeBookmaps.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.EmployeeBookmaps.employees.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
@InjectMocks
    DepartmentService out;

    @Mock
    EmployeeService employeeService = new EmployeeService();

    static Stream<Arguments> employees() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 1000);
        Employee employee2 = new Employee("Petr", "Sidorov", 1, 1100);
        Employee employee3 = new Employee("Anna", "Petrova", 2, 1500);
        Employee employee4 = new Employee("Vasiliy", "Pavlov", 2, 2000);
        return Stream.of(Arguments.of(employee1, employee2, employee3, employee4));
    }
    @ParameterizedTest
    @MethodSource("employees")
    void testMaxSalary( Employee employee1, Employee employee2, Employee employee3, Employee employee4){
        List<Employee> employeeList = List.of(employee1, employee2, employee3, employee4);
        when(employeeService.findAll()).thenReturn(employeeList);

        Employee result = out.maxSalary(1);
        assertNotNull(result);
        assertEquals(1100, result.getSalary());

    }
    @ParameterizedTest
    @MethodSource("employees")
    void testMinSalary( Employee employee1, Employee employee2, Employee employee3, Employee employee4){
        List<Employee> employeeList = List.of(employee1, employee2, employee3, employee4);
        when(employeeService.findAll()).thenReturn(employeeList);

        Employee result = out.minSalary(2);
        assertNotNull(result);
        assertEquals(1500, result.getSalary());

    }
    @ParameterizedTest
    @MethodSource("employees")
    void testEmployeesByDepartment(Employee employee1, Employee employee2, Employee employee3, Employee employee4){
        List<Employee> employeeList = List.of(employee1, employee2, employee3, employee4);
        int departmentId=1;
        when(employeeService.findAll()).thenReturn(employeeList);

        Map<Integer, List<Employee>> result = out.employeesByDepartment(1);
    }
    @ParameterizedTest
    @MethodSource("employees")
    void testAllEmployees(Employee employee1, Employee employee2, Employee employee3, Employee employee4){
        when(employeeService.findAll()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));
        List<Employee> expectedListDepartment1 = Arrays.asList(employee1,employee2);
        List<Employee> expectedListDepartment2 = Arrays.asList(employee3,employee4);
        Map<Integer, List<Employee>> resultListDepartments = out.allEmployees();
        Map<Integer, List<Employee>> expectedResultListDepartments = Map.of(1, expectedListDepartment1, 2, expectedListDepartment2);
        assertEquals(2, expectedResultListDepartments.size());

        assertEquals(expectedResultListDepartments, resultListDepartments);
    }
}
