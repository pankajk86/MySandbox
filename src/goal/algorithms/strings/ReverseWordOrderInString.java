package goal.algorithms.strings;

public class ReverseWordOrderInString {

    public static void main(String[] args) {
        String s = "Once upon a time, there was a boy.";
        char[] charArray = s.toCharArray();

        // first reverse the whole string.
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        int j = 0;
        // in this loop, we will reverse each of the single words
        while (j < charArray.length) {
            int i = j;
            // keep looking for the whitespaces.
            while (charArray[j] != ' ') {
                j++;
                if (j == charArray.length) {
                    break;
                }
            }

            /*
             * Now, at this position, i will be at the beginning of the word,
             * and j will be at the whitespace just after the after. so here, we
             * need to reverse[i, j).
             */
            for (int l = i, m = j; l < m; l++, m--) {
                char temp = charArray[l];
                charArray[l] = charArray[m - 1];
                charArray[m - 1] = temp;
            }

            j++;
        }

        System.out.println(new String(charArray));
    }

}
