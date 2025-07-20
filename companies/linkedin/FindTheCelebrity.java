package linkedin;

public class FindTheCelebrity {

    private static final int[][] graph = {
            {1, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
    };

    public static void main(String[] args) {
        int result = findCelebrity(3);
        System.out.println(result);
    }

    public static int findCelebrity(int n) {
        int celebrity = 0;

        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) celebrity = i;
        }

        for (int i = 0; i < n; i++) {
            if (celebrity != i && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
        }
        return celebrity;
    }

    private static boolean knows(int i, int j) {
        return i != j && graph[i][j] == 1;
    }
}
