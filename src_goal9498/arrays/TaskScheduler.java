package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int n = 2;

		int result = leastIntervalCorrect(tasks, n);
		System.out.println(result);
	}

	private static int leastIntervalCorrect(char[] tasks, int n) {
		int[] c = new int[26];

		for (char t : tasks) {
			c[t - 'A']++;
		}

		Arrays.sort(c);

		int i = 25;
		while (i >= 0 && c[i] == c[25]) {
			i--;
		}

		int interval = Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
		return interval;
	}

	@SuppressWarnings("unused")
	private static int leastInterval(char[] tasks, int n) {

		List<Character> result = new ArrayList<>();
		Map<Character, Integer> taskMap = new HashMap<>();

		for (char c : tasks) {
			if (!taskMap.containsKey(c)) {
				taskMap.put(c, 1);
			} else {
				taskMap.put(c, taskMap.get(c) + 1);
			}
		}

		Task[] taskList = new Task[taskMap.size()];
		int i = 0;

		for (Map.Entry<Character, Integer> entry : taskMap.entrySet()) {
			Task task = new Task(entry.getKey(), entry.getValue());
			taskList[i++] = task;
		}

		int presentInterval = 1, size = tasks.length;
		i = 0;

		for (i = 0; size > 0;) {
			Task currentTask = taskList[i];

			if (currentTask.count > 0) {
				if (currentTask.lastInterval == 0 || presentInterval - currentTask.lastInterval > n) {
					result.add(currentTask.name);
					currentTask.lastInterval = presentInterval;

					currentTask.count--;
					size--;
					i++;

					if (i == taskList.length) {
						i = 0;
					}

				} else {
					result.add('-');
				}
				presentInterval++;
			} else {
				i++;

				if (i == taskList.length) {
					i = 0;
				}
			}
		}

		return result.size();
	}

}

class Task {
	char name;
	int count;
	int lastInterval;

	public Task(char name, int count) {
		this.name = name;
		this.count = count;
	}
}
