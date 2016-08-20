package goal.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeComparatorTest {

    public static void main(String[] args) {
        Employee e1 = new Employee(2, "pankaj", "kumar");
        Employee e2 = new Employee(1, "sushil", "kumar");
        Employee e3 = new Employee(3, "neelam", "kumari");

        List<Employee> list = new ArrayList<Employee>();
        list.addAll(Arrays.asList(e1, e2, e3));

        Collections.sort(list, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.id > o2.id ? 1 : (o1.id < o2.id ? -1 : 0);
            }

        });
        
        System.out.println("Sorted by id: ");
        for (Employee e : list) {
            System.out.println(e.id + ": " + e.fname + " " + e.lname);
        }

        Collections.sort(list, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.fname.compareTo(o2.fname);
            }

        });

        System.out.println("Sorted by first name: ");
        for (Employee e : list) {
            System.out.println(e.id + ": " + e.fname + " " + e.lname);
        }

    }

    private static class Employee {
        int id;
        String fname;
        String lname;

        public Employee(int id, String fname, String lname) {
            this.id = id;
            this.fname = fname;
            this.lname = lname;
        }
    }

}
