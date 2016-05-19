package goal.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class SplitStringByBufferSize {

    public static void main(String[] args) {

        String str = "Hi Sivasrinivas, your Uber is arriving now! And this is a very long string!!";
        int buffer = 15;
        List<String> splits = splitString(str, buffer);

        for (String split : splits) {
            System.out.println(split);
        }
    }

    private static List<String> splitString(String str, int buffer) {
        
        List<String> list = new ArrayList<String>();
        int j = 0;
        
        for (int i = 0; i < str.length(); i = j + 1) {
            j = i + buffer;

            if (j > str.length()) {
                if (str.charAt(i) == ' ') {
                    list.add(str.substring(i + 1));
                } else {
                    list.add(str.substring(i));
                }
            } else {

                if (str.charAt(i) == ' ') {
                    i = i + 1;
                }

                if (str.charAt(j) == ' ') {
                    list.add(str.substring(i, j));
                } else {
                    if (str.charAt(j + 1) == ' ') {
                        list.add(str.substring(i, j + 1));
                    } else {
                        while (str.charAt(j) != ' ') {
                            j--;
                        }
                        list.add(str.substring(i, j + 1));
                    }

                }
            }
        }
        
        return list;
    }

}
