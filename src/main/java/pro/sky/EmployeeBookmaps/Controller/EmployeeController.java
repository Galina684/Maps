package pro.sky.EmployeeBookmaps.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.EmployeeBookmaps.employees.Employee;
import pro.sky.EmployeeBookmaps.service.EmployeeServiceInterface;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInterface employeeServiceInterface;

    public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
        this.employeeServiceInterface = employeeServiceInterface;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam Integer salary) {
        return employeeServiceInterface.add(firstName, lastName, departmentId,
                salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam Integer salary) {
        return employeeServiceInterface.remove(firstName, lastName, departmentId,
                salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam Integer salary) {
        return employeeServiceInterface.find(firstName, lastName, departmentId,
                salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeServiceInterface.findAll();
    }
}
