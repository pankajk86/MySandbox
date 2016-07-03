package goal.phase.two.graphs;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {

        Map<Employee, Integer> empSalary = new HashMap<Employee, Integer>();
        Employee e1 = new Employee("e1", "Pankaj");
        Employee e2 = new Employee("e2", "Sushil");
        Employee e3 = new Employee("e3", "Neelam");

        empSalary.put(e1, 10000);
        empSalary.put(e2, 20000);
        empSalary.put(e3, 15000);

        System.out.println("Salary of e2: " + empSalary.get(e2));
        System.out.println("Salary of e1: " + empSalary.get(e1));
        System.out.println("Salary of e3: " + empSalary.get(e3));
    }

    static class Employee {
        String id;
        String name;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public boolean equals(Employee e) {
            return (this.id == e.id);
        }

        public int hashCode() {
            final int prime = 31;
            return prime * id.hashCode();
        }
    }

}
