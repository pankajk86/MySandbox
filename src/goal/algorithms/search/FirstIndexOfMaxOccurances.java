package goal.algorithms.search;

public class FirstIndexOfMaxOccurances {

    public static void main(String[] args) {
        String str = "abbbbcccaaaaaaa";
        int index = getFirstIndexOfMaxOccurances(str);
        System.out.println("First Index of Max Occurance: " + index);
    }

    private static int getFirstIndexOfMaxOccurances(String str) {

        int maxCount = 0;
        int maxIndex = 0;
        char chArr[] = str.toCharArray();
        char begin = chArr[0];
        int localCount = 1;

        for (int i = 0; i < chArr.length;) {
            int localIndex = i;
            while (chArr[i] == begin) {
                i++;
                if (i == (chArr.length)) {
                    break;
                }
            }
            localCount = (i - localIndex);

            if (i < chArr.length) {
                begin = chArr[i];
            }

            if (localCount > maxCount) {
                maxCount = localCount;
                maxIndex = localIndex;
            }
        }

        return maxIndex;
    }

}
