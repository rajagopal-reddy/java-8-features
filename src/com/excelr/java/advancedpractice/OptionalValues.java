package com.excelr.java.advancedpractice;

import java.util.List;
import java.util.Optional;


/*
Optional Class

Create a method findEmployeeById(int id) that returns an Optional<Employee>.
Use Optional methods like ifPresent, orElse, and orElseThrow.
 */
class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class OptionalValues {
    static List<Employee> emps = List.of(
                new Employee(101,"Ajay"),
                new Employee(102,"Vinay"),
                new Employee(103,"Raju"),
                new Employee(104,"Max"),
                new Employee(105,"Gido"),
                new Employee(106,"Kick"),
                new Employee(107,"Sid"),
                new Employee(108,"Fan"),
                new Employee(109,"Moni")
        );

    public static Optional<Employee> findEmp(int id) {
        return emps.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
    public static void main(String[] args) {

        int empId = 107;

        findEmp(empId).ifPresent(System.out::println);

        Employee employeeDefault = new Employee(0, "Default");

        Employee employee = findEmp(100).orElse(employeeDefault);

        System.out.println(employee);

        try {
            Employee foundEmp = findEmp(100).orElseThrow(() -> new RuntimeException("Employee not found !"));
            System.out.println(foundEmp);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}