package goal.java.generics;

import java.util.HashSet;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		String a = "abc";
		String b = a;
		String c = "abc";
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.hashCode());
		System.out.println(c.hashCode());
		
		Student s1 = new Student(1, "Pankaj");
		Student s2 = new Student(1, "Pankaj");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		Set<Student> set = new HashSet<>();
		set.add(s1); set.add(s2);
		System.out.println(set.size());
		System.out.println(set.contains(new Student(1, "Pankaj")));
	}

}

class Student {
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Student))
			return false;

		if(o == this)
			return true;
		
		Student s = (Student) o;
		
		if(this.id == s.id && this.name.equals(s.name))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}