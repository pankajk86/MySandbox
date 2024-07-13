package facebook;

import java.util.Random;

public class RandomPickIndex {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3};
        Solution solution = new Solution(a);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
    }
}

class Solution {
    private Random rand;
    private int[] a;

    public Solution(int[] a) {
        this.a = a;
        this.rand = new Random();
    }

    public int pick(int target) {
        int index = rand.nextInt(a.length);
        if (a[index] == target) return index;
        else return pick(target);
    }
}
