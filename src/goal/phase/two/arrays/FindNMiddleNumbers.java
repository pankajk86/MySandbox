package goal.phase.two.arrays;

public class FindNMiddleNumbers {

    public static void main(String[] args) {

        int start = 0, end = 5, n = 2;
        int[] result = getMiddleNumbers(start, end, n);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    private static int[] getMiddleNumbers(int start, int end, int n) {

        int result[] = new int[n];
        
        /*
         * (end-start+1) -> actual range of the numbers
         * -n -> Total numbers that we actually need
         * -2 -> start and end numbers
         * /2 -> to get the middle numbers 
         */
        int index = (end - start + 1 - n - 2) / 2;

        int effectiveStart = start + index + 1;
        int i = 0;

        while (i < n) {
            result[i] = effectiveStart;
            i++;
            effectiveStart++;
        }

        return result;
    }

}
