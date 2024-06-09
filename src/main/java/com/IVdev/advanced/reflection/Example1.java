package com.IVdev.advanced.reflection;

import java.lang.reflect.Field;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        //способы получения класса Employee, для наглядности - без generics
        //1.
        Class<?> emp = Class.forName("reflection.Employee");

//        2.
//        Class emp2 = Employee.class;
//
//        3.
//        Employee employee = new Employee();
//        Class emp3 = employee.getClass();

        Field f1 = emp.getField("id");
        System.out.println("Type of fielf " + f1 + " is" + f1.getType());
        System.out.println("------------------------------");

        Field [] fields = emp.getFields();
        for (Field f : fields) {
            System.out.println("Type of " + f.getName() + " is" + f.getType());
        }
    }
}
