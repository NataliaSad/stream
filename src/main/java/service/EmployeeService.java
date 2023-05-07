package service;

import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    private static final int SIZE = 6;
    private Employee[] staff = new Employee[SIZE];
    EmployeeService() {
        staff[0] = new Employee("A", 50.0, 1);
        staff[1] = new Employee("B", 55.0, 1);
        staff[2] = new Employee("C", 45.0, 1);
        staff[3] = new Employee("D", 35.0, 2);
        staff[4] = new Employee("E", 56.0, 2);
        staff[5] = new Employee("F", 65.0, 2);

    }

    public Employee getMaxPaidByDept(int dept) {
        return Arrays.stream(staff)
        .filter(e -> e != null)
    .filter(e -> e.getDept() == dept)
                .max(Comparator.comparingDouble(Employee::getSalary))
        .orElseThrow(() -> new IllegalArgumentException("Department number is invalid"));
    }

    public Employee getMinPaidByDept(int dept) {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDept() == dept)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Department number is invalid"));
    }
    public List<Employee> showAll() {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .sorted(Comparator.comparingInt(Employee::getDept))
                .collect(Collectors.toList());
    }
    public List<Employee> showByDept(int id) {
        return Arrays.stream(staff)
                .filter(e -> e != null)
                .filter(e -> e.getDept() == id)
                .collect(Collectors.toList());
    }

    public Employee getMinPaidByDept(Integer id) {
        return null;
    }
    public Employee getMaxPaidByDept(Integer id)  {
        return null;
    }
}
