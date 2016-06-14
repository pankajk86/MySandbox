package goal.phase.two.strings;

public class VersionComparator {

    public static void main(String[] args) {

        String s1 = "1.1.3.0", s2 = "13.1.3";
        int result = compareVersions(s1, s2);
        System.out.println("Result: " + result);
    }

    private static int compareVersions(String version1, String version2) {

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int length = Math.min(s1.length, s2.length);

        for (int i = 0; i < length; i++) {
            int a = Integer.parseInt(s1[i]);
            int b = Integer.parseInt(s2[i]);

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }

        if (s1.length == s2.length) {
            return 0;
        }

        if (s1.length > length) {
            int value = Integer.parseInt(s1[length]);
            if (value == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        if (s2.length > length) {
            int value = Integer.parseInt(s2[length]);
            if (value == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        return -1;
    }

}
