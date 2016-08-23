package goal.design.patterns.singleton;

public class StaticAndNonStaticClass {

    private static String staticVar = "static string";
    private String nonStaticVar = "non static string";

    public static class StaticClass {
        public void nonStaticMethod() {
            System.out.println("This is a non static method in static class.");
            System.out.println("Static var in non static class method: " + staticVar);
        }

        public static void staticMethod() {
            System.out.println("This is a static method is static class.");
            System.out.println("Static var in static class method: " + staticVar);
        }
    }

    public class NonStaticClass {
        public void nonStaticMethod() {
            System.out.println("This is a non static method in non static class.");
            System.out.println("Static var in non static class method: " + staticVar);
            System.out.println("Non static var in non static class method: " + nonStaticVar);
        }
    }
}
