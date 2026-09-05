package com.amigoscode._3_oop._3_abstractclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 *
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 *
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

abstract class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(double baseSalary, String name) {
        this.baseSalary = baseSalary;
        this.name = name;
    }

    abstract double calculatePay();


    // TODO: 3 - Create a concrete method: String getDetails()
    //   Return: "<name> - Pay: $<calculatePay()>"
    //   Use String.format("%.2f", calculatePay()) for formatting.
    public String getDetails(){
        return  this.name+
                " - Pay: $" +
                String.format("%.2f", calculatePay());
    }

}

// TODO: 4 - Create a FullTimeEmployee class that extends Employee.
//   - Constructor takes name and baseSalary, calls super(name, baseSalary)
//   - Implement calculatePay() to simply return baseSalary
class FullTimeEmployee extends Employee{

    public FullTimeEmployee(double baseSalary, String name) {
        super(baseSalary, name);
    }

    @Override
    double calculatePay() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name='" + name + '\'' +
                '}';
    }
}


// TODO: 5 - Create a ContractEmployee class that extends Employee.
//   - Add two private fields: hourlyRate (double) and hoursWorked (int)
//   - Constructor takes name, hourlyRate, and hoursWorked
//     (pass name and 0.0 as baseSalary to super)
//   - Implement calculatePay() to return hourlyRate * hoursWorked
class ContractEmployee extends Employee{

    private double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(double baseSalary, String name, double hourlyRate, int hoursWorked) {
        super(0.0, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "name='" + name + '\'' +
                '}';
    }
}


// TODO: 6 - In the EmployeeDemo class below, complete the main method:
//   - Create a List<Employee> with at least one FullTimeEmployee
//     and one ContractEmployee
//   - Iterate over the list and print getDetails() for each employee

// TODO: 7 - Add a method in EmployeeDemo: static Employee getHighestPaid(List<Employee> employees)
//   that returns the employee with the highest calculatePay() value.
//   Call it from main and print the result.

class EmployeeDemo {
    public static void main(String[] args) {
        // Complete TODOs 6 and 7 here
        List<Employee> employees = new ArrayList<>(
                List.of(
                        new FullTimeEmployee(100_000, "Joe"),
                        new ContractEmployee(0.0, "John", 70.0, 2_080)
                )
        );

        for (Employee employee : employees){
            System.out.println(employee.getDetails());
        }

        System.out.println(getHighestPaid(employees));
    }

    static Employee getHighestPaid(List<Employee> employees){
        double maxPay = 0.0;
        Employee highestPaid = null;

        for (int i = 0; i < employees.size(); i++) {
            double pay = employees.get(i).calculatePay();

            if (pay <= maxPay) continue;

            maxPay = pay;
            highestPaid = employees.get(i);
        }

        return highestPaid;
    }
}