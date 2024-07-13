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
		Stack<Log> stack = new Stack<>();
		int[] result = new int[n];
		int prev = 0;

		for(String log : logs) {
			Log l = new Log(log);

			if (l.isStart) {
				if (!stack.isEmpty()) result[stack.peek().id] += l.time - prev;
				stack.push(l);
				prev = l.time;
			} else {
				result[stack.pop().id] += l.time + 1 - prev;
				prev = l.time + 1;
			}
		}
		return result;
	}

}

class Log {
	int id;
	boolean isStart;
	int time;

	public Log(String log) {
		String[] parts = log.split(":");
		id = Integer.parseInt(parts[0]);
		isStart = parts[1].equals("start");
		time = Integer.parseInt(parts[2]);
	}
}
