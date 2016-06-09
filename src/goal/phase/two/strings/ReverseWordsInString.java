package goal.phase.two.strings;

public class ReverseWordsInString {

    public static void main(String[] args) {

        String test = "I am not going to give up.";

        String reversedWords = getReversedWords(test.toCharArray());
        System.out.println(reversedWords);
    }

    private static String getReversedWords(char[] s) {

        reverseWord(s, 0, s.length - 1);

        int i = 0;

        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ') {
                reverseWord(s, i, j - 1);
                i = j + 1;
            }
        }

        return String.valueOf(s);
    }

    private static void reverseWord(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

}
