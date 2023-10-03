package pro.sky.EmployeeBookmaps.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
private final DepartmentServiceInterface departmentServiceInterface;

    public DepartmentController(DepartmentServiceInterface departmentServiceInterface, EmployeeServiceInterface employeeServiceInterface) {
        this.departmentServiceInterface = departmentServiceInterface;

    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam Integer salary) {
        return departmentServiceInterface.add(firstName, lastName, departmentId,
                salary);
    }
    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentServiceInterface.maxSalary(departmentId);
    }
        @GetMapping("/min-salary")
        public Employee minSalary( @RequestParam int departmentId)
        {
            return departmentServiceInterface.minSalary(departmentId);
        }

}
