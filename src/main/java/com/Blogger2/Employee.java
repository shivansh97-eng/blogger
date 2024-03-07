//package com.Blogger2;
//
//import java.util.Comparator;
//
//public class Employee implements Comparable<Employee> {
//    private String name;
//    private int salary;
//    private String city;
//
//    public Employee(String name, int salary, String city) {
//        this.name = name;
//        this.salary = salary;
//        this.city = city;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//
//
//    @Override
//    public int compareTo(Employee o) {
//        return this.getSalary()-o.getSalary();
//    }
//}

//05/12/23

package com.Blogger2;

import java.util.Comparator;

public class Employee{
    private String name;

    private double salary;

    private String city;

    public Employee(String name, double salary, String city) {
        this.name = name;
        this.salary = salary;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}