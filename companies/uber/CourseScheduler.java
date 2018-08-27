package uber;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduler {

	public static void main(String[] args) {
		int n = 5;
		int[][] a = {
				{1, 0},
				{2, 0},
				{0, 3},
				{2, 4},
				{4, 3}
		};
		
		boolean result = canFinish(n, a);
		System.out.println(result);
	}

	private static boolean canFinish(int n, int[][] a) {

		Course[] courses = new Course[n];
		
		for(int i = 0; i < n; i++)
			courses[i] = new Course();
		
		for(int[] pre: a) {
			Course c1 = courses[pre[0]];
			Course c2 = courses[pre[1]];
			c1.addPre(c2);
		}
		
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].isCyclic())
				return false;
		}
		
		return true;
	}

}

class Course {
	boolean visited, done;
	List<Course> pre = new ArrayList<>();
	
	public void addPre(Course c) {
		this.pre.add(c);
	}
	
	public boolean isCyclic() {
		if(done) return false;
		if(visited) return true;
		visited = true;
		
		for(Course c: pre) {
			if(c.isCyclic())
				return true;
		}
		done = true;
		return false;
	}
}
