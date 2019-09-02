package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

	public static void main(String[] args) {
		int n = 3;
		List<String> logs = new ArrayList<>();
		n = 2;
		logs.addAll(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
//		logs.addAll(Arrays.asList("0:start:0","1:start:10","2:start:15","2:end:17",
//				"0:start:18","0:end:22","1:end:25","0:end:30"));
		
		int[] result = exclusiveTime(n, logs);
		for(int i: result) {
			System.out.print(i + ", ");
		}
	}
	
	private static int[] exclusiveTime(int n, List<String> logs) {
		
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		int previous = 0;
		
		for(String log: logs) {
			String[] parts = log.split(":");
			int id = Integer.parseInt(parts[0]);
			int duration = Integer.parseInt(parts[2]);
			
			if(parts[1].equals("start")) {
				if(!stack.isEmpty() ) {
					result[stack.peek()] += duration - previous;
				}
				stack.push(id);
				previous = duration;
			} else {
				result[stack.pop()] += duration - previous + 1;
				previous = duration + 1;
			}
		}
		
		return result;
	}

	@SuppressWarnings("unused")
	private static int[] exclusiveTime2(int n, List<String> logs) {

		int[] result = new int[n];
		Stack<Function> stack = new Stack<>();
		String[] parts = logs.get(0).split(":");
		stack.push(new Function(Integer.parseInt(parts[0]), Integer.parseInt(parts[2])));
		
		for(int i = 1; i < logs.size(); i++) {
			parts = logs.get(i).split(":");
			
			if(parts[1].equals("start")) {
				Function f = stack.pop();
				f.duration = Integer.parseInt(parts[2]) - f.duration;
				stack.push(f);
				
				stack.push(new Function(Integer.parseInt(parts[0]), Integer.parseInt(parts[2])));
			} else if(parts[1].equals("end")) {
				Function f = stack.pop();
				String[] previousJob = logs.get(i - 1).split(":");
				
				if(parts[0].equals(previousJob[0])) {
					result[f.id] += Integer.parseInt(parts[2]) - f.duration + 1;
				} else {
					result[f.id] += f.duration + (Integer.parseInt(parts[2]) - Integer.parseInt(previousJob[2])) ;
				}
			}
		}
		
		return result;
	}

}

class Function {
	int id; int duration;
	
	Function(int id, int duration) {
		this.id = id;
		this.duration = duration;
	}
}
