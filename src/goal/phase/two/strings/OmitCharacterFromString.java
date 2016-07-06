package goal.phase.two.strings;

public class OmitCharacterFromString {

    public static void main(String args[]) {
        String s = "google";
        char c = 'g';

        StringBuilder sb = new StringBuilder();
        for (char schar : s.toCharArray()) {
            if (schar != c) {
                sb.append(schar);
            }
        }

        String omitted = sb.toString();
        System.out.println("Omitted string: " + omitted);
    }
}
