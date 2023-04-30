package model;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private int dept;

    public Employee(String name, double salary, int dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dept=" + dept +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && dept == employee.dept &&  Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, dept);
    }



    public String getName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.salary = salary;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }
}
