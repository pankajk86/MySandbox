package facebook;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {

    public static void main(String[] args) {
        int[] tasks = {1, 2, 1, 2, 3, 1};
        int space = 3;

        long result = taskSchedulerII(tasks, space);
        System.out.println(result);
    }

    /**
     *
     * The last task of type a is completed on day last[a].
     * Currently, it takes us res day.
     *
     * For the task a,
     * we can do it on res + 1 day,
     * and it needs to be bigger than last[a] + space.
     * So this task is completed on max(res, last[a] + space) + 1.
     *
     * We keep doing this for all tasks, and finally return result res
     *
     * Time O(n)
     * Space O(n)
     *
     * @param tasks
     * @param space
     * @return
     */
    private static long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long result = 0;

        for (int task : tasks) {
            result = Math.max(result, map.getOrDefault(task, result));
            map.put(task, result + space + 1);
            result++;
        }
        return result;
    }
}
