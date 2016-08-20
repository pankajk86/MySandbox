package goal.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeComperableTest {

    public static void main(String[] args) {
        Employee e1 = new Employee(2, "pankaj", "kumar");
        Employee e2 = new Employee(1, "sushil", "kumar");
        Employee e3 = new Employee(3, "neelam", "kumari");

        List<Employee> list = new ArrayList<Employee>();
        list.addAll(Arrays.asList(e1, e2, e3));
        Collections.sort(list);

        for (Employee e : list) {
            System.out.println(e.id + ": " + e.fname + " " + e.lname);
        }
    }

    private static class Employee implements Comparable<Employee> {
        int id;
        String fname;
        String lname;

        public Employee(int id, String fname, String lname) {
            this.id = id;
            this.fname = fname;
            this.lname = lname;
        }

        @Override
        public int compareTo(Employee e) {
            return (e.id > this.id ? -1 : (e.id < this.id ? 1 : 0));
        }
    }
}
