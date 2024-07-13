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
			courses[pre[0]].pre.add(courses[pre[1]]);
		}

        for (Course course : courses) {
            if (course.isCyclic())
                return false;
        }
		
		return true;
	}

}

class Course {
	public boolean visited, done;
	public List<Course> pre = new ArrayList<>();
	
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
