package goal.arithmetic;

public class BinarySearchInTwoDArray {

    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test1() {
        int[][] arr = { 
                {  1,  3,  5,  7 }, 
                { 10, 11, 16, 20 }, 
                { 23, 30, 34, 50 } 
                };

        // int [][] arr = {{1}};
        int target = 11;

        System.out.println("Test1: ");
        int rowIndex = getRow(arr, 0, arr.length - 1, target);
        int columnIndex = getColumn(arr[rowIndex], 0, arr[0].length - 1, target);

        System.out.println("Row: " + rowIndex + ", Column:" + columnIndex);

        boolean doesTargetExist = searchInTwoDArray(arr, target);
        System.out.println(target + " exists? : " + doesTargetExist);
    }
    
    private static void test2() {
        int[][] arr = { 
                { 15, 20, 40, 85 }, 
                { 20, 35, 80, 95 }, 
                { 30, 55, 95, 105 },
                { 40, 80, 100, 120 }
            };

        int target = 55;

        System.out.println("Test2: " + search(arr, target));
    }

    /*
     * Time Complexity : O(M log N), where M = # of rows, N = # of columns
     */
    private static boolean search(int[][] a, int target) {
        int row = 0, col = a[0].length - 1;

        while (row < a.length && col >= 0) {
            if (a[row][col] == target) {
                return true;
            } else if (a[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    private static boolean searchInTwoDArray(int[][] a, int target) {

        int m = a.length;
        int n = a[0].length;

        int start = 0, end = (m * n - 1);

        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;

            if (a[midX][midY] == target) {
                return true;
            } else if (a[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    private static int getRow(int[][] arr, int low, int high, int target) {

        if (low == high) {
            return low;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid][0] <= target && mid == high || arr[mid][0] <= target && arr[mid + 1][0] > target) {
            return mid;
        }

        if (arr[mid][0] > target) {
            return getRow(arr, low, mid - 1, target);
        } else {
            return getRow(arr, mid + 1, high, target);
        }
    }

    private static int getColumn(int[] arr, int low, int high, int target) {

        if (low == high) {
            if (arr[low] == target) {
                return low;
            } else {
                return -1;
            }
        }

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return getColumn(arr, mid + 1, high, target);
        } else {
            return getColumn(arr, low, mid - 1, target);
        }

    }

}
