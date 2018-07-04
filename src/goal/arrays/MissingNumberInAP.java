package goal.arrays;

public class MissingNumberInAP {

    public static void main(String[] args) {

        int nums[] = { 1, 3, 5, 9, 11 };
        int sum = 29;
        int n = 5;
        int num = (int) (0.5 * (nums[0] + nums[n - 1]) * (n + 1) - sum);
        System.out.println(num);
    }

}
