package goal.phase.two.strings;

public class ReplaceWhitepaces {

    public static void main(String[] args) {

        char[] arr = "abc def ghi".toCharArray();
        arr = replacedWhitespaces(arr);
        System.out.println(String.valueOf(arr));
    }

    private static char[] replacedWhitespaces(char[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr = replace(i, arr);
            }
        }

        return arr;
    }

    private static char[] replace(int i, char[] arr) {

        char[] newArr = new char[arr.length + 2];
        int j, k;

        for (j = arr.length - 1, k = newArr.length - 1; j > i; j--, k--) {
            newArr[k] = arr[j];
        }

        newArr[k--] = '0';
        newArr[k--] = '2';
        newArr[k--] = '%';

        while (k >= 0) {
            newArr[k] = arr[k];
            k--;
        }

        return newArr;
    }

}
