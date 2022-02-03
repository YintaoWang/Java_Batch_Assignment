package com.yintaowang.assignment;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * 1. create employee class(name / age)
 * create employee list, sort emp list by name(descending), age(ascending), return a new list
 */
public class Employee implements Cloneable {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class EmployeeListHelper {

    public static ArrayList<Employee> sort(ArrayList<Employee> employees) {
        //make a copy of the list(deep copy)
        ArrayList<Employee> sorted = new ArrayList<>();
        for (Employee employee : employees) {
            try {
                sorted.add((Employee) employee.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        //name:descending age:ascending
        sorted.sort(Comparator.comparing(Employee::getName).reversed().thenComparing(Employee::getAge));
        return sorted;
    }
}

class EmployeeTest {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Judy", 30));
        employees.add(new Employee("Wendy", 34));
        employees.add(new Employee("Kevin", 20));
        employees.add(new Employee("Wendy", 40));
        employees.add(new Employee("Sara", 31));
        employees.add(new Employee("Tony", 43));
        employees.add(new Employee("Sara", 13));

        ArrayList<Employee> sorted = EmployeeListHelper.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("******************************");
        for (Employee employee : sorted) {
            System.out.println(employee);
        }
    }
}