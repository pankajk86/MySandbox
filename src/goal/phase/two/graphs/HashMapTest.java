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

        System.out.println("Salary of e2: " + empSalary.get(new Employee("e2", "Sushil")));
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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            Employee other = (Employee) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

    }

}
