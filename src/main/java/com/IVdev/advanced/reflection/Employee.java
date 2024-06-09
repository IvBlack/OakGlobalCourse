package com.IVdev.advanced.reflection;

import lombok.Data;

@Data
public class Employee {
    public int id;
    public String name;
    public String department;
    private double salary;

    public Employee() {}

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    private void changeDepartment(String newDepartment) {
        department=newDepartment;
        System.out.println("New dep is " + department);
    }
}


