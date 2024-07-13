package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int result = minMeetingRooms(intervals);
        System.out.println(result);
    }

    private static int minMeetingRooms(int[][] a) {
        int n = a.length;
        int result = 0, count = 0;
        int[] start = new int[n], end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = a[i][0];
            end[i] = a[i][1];
        }

        Arrays.sort(start); Arrays.sort(end);

        for (int i = 0, j = 0; i < n; ) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

}

