package com.super_market;

import java.util.ArrayList;
import java.util.List;

public class Employee implements UserAsEmployee {

    String empId;

    // designation
    // join date

    UserIntf user;

    public Employee(String empId, UserIntf user) {
        this.empId = empId;
        this.user = user;
    }

    public String getName() {
        return user.getName();
    }

    public String getPhoneNumber() {
        return user.getPhoneNumber();
    }

    public String getEmpId() {
        return empId;
    }

    // only for initialization
    static List<Employee> employeeList = new ArrayList<>();

    // we can generate the employee id as unique
    public static void init() {
        employeeList.add(new Employee("emp_001", new User("Emp A", "22771818")));
        employeeList.add(new Employee("emp_002", new User("Emp B", "9877869275")));
    }

    public static void print() {
        for (Employee emp : employeeList) {
            System.out.println("Emp Id: " + emp.getEmpId());
            System.out.println("Name : " + emp.getName());
            System.out.println("Phone: " + emp.getPhoneNumber());
        }
    }

}
