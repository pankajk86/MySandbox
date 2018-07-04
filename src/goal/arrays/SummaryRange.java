package goal.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

    public static void main(String[] args) {
        int[] arr = { 0, 1 };

        List<String> list = getSummaryList(arr);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> getSummaryList(int[] nums) {
        String str = "";
        int begin = nums[0];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            j = i + 1;
            if (j == nums.length) {
                break;
            }
            if (nums[j] != nums[i] + 1) {
                if (begin != nums[j - 1]) {
                    str += begin + "->" + nums[j - 1] + ";";
                } else {
                    str += begin + ";";
                }

                begin = nums[j];
            }
        }
        str += begin;

        if (begin != nums[j - 1]) {
            str += "->" + nums[j - 1];
        }

        String[] strArr = str.split(";");
        List<String> list = new ArrayList<String>();

        for (String s : strArr) {
            list.add(s);
        }

        return list;
    }

}
