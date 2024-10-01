package uber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedulerII {
	
	public static void main(String[] args) {
		int[][] a = {
				{1, 2}, {1, 0},
				{2, 3}, {4, 2},
				{4, 5}, {5, 6},
				{6, 7} //, {7, 4}
		};
		int n = 8;
		
		int[] result = findOrder(n, a);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findOrder(int n, int[][] pres) {
		if (n == 0) return null;
	    int[] inDegree = new int[n];
        int[] order = new int[n];
        int index = 0;
        // Indegree - how many prerequisites are needed.
        for (int[] pre : pres) inDegree[pre[0]]++;
		
	    Queue<Integer> q = new LinkedList<>();
	    
	    // those courses for which, no prerequisites are needed
	    for(int i = 0; i < n; i++) {
	    	if(inDegree[i] == 0) {
	    		order[index++] = i;
	    		q.add(i);
	    	}
	    }
	    
	    while(!q.isEmpty()) {
	    	int curr = q.poll();
            for (int[] pre : pres) {
                if (pre[1] == curr) {
                    int preFor = pre[0];
                    inDegree[preFor]--;

                    if (inDegree[preFor] == 0) {
                        order[index++] = preFor;
                        q.add(preFor);
                    }
                }
            }
	    }
	    
		return index == n ? order : new int[0];
	}

}

