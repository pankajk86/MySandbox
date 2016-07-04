package goal.phase.two.strings;

public class StringTest {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello"); // new String("Hello").intern(); in
                                         // this case s1==s3

        System.out.println("Same reference? " + (s1 == s2));
        System.out.println("Same object? " + s1.equals(s2));

        System.out.println("Same reference? " + (s1 == s3));
        System.out.println("Same object? " + s1.equals(s3));
    }

}
