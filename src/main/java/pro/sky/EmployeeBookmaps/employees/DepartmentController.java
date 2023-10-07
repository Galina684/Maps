package pro.sky.EmployeeBookmaps.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceInterface departmentServiceInterface;

    public DepartmentController(DepartmentServiceInterface departmentServiceInterface, EmployeeServiceInterface employeeServiceInterface) {
        this.departmentServiceInterface = departmentServiceInterface;

    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentServiceInterface.maxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentServiceInterface.minSalary(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentID")
    public Map<Integer, List<Employee>> allDepartments(@RequestParam int departmentId) {
        return departmentServiceInterface.employeesByDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployees() {
        return departmentServiceInterface.allEmployees();
    }
}
