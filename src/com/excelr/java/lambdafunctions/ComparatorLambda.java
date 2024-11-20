package com.excelr.java.lambdafunctions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class ComparatorLambda {
    public static void main(String[] args) {

        List<Employee> emp = new ArrayList<>(List.of(
                new Employee("Gopal", 24, 35000),
                new Employee("Rahul", 14, 15000),
                new Employee("Rohan", 27, 65000),
                new Employee("Haru", 25, 55000),
                new Employee("Susu", 26, 70000),
                new Employee("Lina", 20, 2000),
                new Employee("Pham", 22, 1000),
                new Employee("Hadi", 26, 10000),
                new Employee("Raju", 29, 20000)
        ));

        System.out.println("Age in ascending order: ");
        List<Employee> sortedAge = emp.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .toList();

        sortedAge.forEach(System.out::println);

        System.out.println("Salary in descending order: ");
        List<Employee> sortedSalary = emp.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        sortedSalary.forEach(System.out::println);

        System.out.println("Age in ascending order: ");
        emp.sort(Comparator.comparingInt(e -> e.age));
        emp.forEach(System.out::println);

        System.out.println("Salary in descending order: ");
        emp.sort((e1,e2) -> Double.compare(e2.salary,e1.salary));
        emp.forEach(System.out::println);
    }
}