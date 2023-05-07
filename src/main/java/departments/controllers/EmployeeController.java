package departments.controllers;


import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService service;
    EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/departments")
    public String welcome() {
        return "Welcome to Departments";
    }
    @GetMapping("/departments/max-salary")
    public Employee getMaxPaidByDept(@RequestParam("departmentId") Integer id) {
        return service.getMaxPaidByDept(id);
    }
    @GetMapping("/departments/min-salary")
    public Employee getMinPaidByDept(@RequestParam("departmentId") Integer id) {
        return service.getMinPaidByDept(id);
    }
    @GetMapping("/departments/all")
    public List<Employee> getEmployeeByDept(@RequestParam(value = "departmentId", required = false ) Integer id) {
        if (id == null) {
            return service.showAll();
        }
        return service.showByDept(id);
    }


}
