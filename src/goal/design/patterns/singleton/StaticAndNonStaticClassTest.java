package goal.design.patterns.singleton;

import goal.design.patterns.singleton.StaticAndNonStaticClass.StaticClass;

public class StaticAndNonStaticClassTest {

    public static void main(String[] args) {
        StaticAndNonStaticClass.StaticClass sclass = new StaticAndNonStaticClass.StaticClass();
        sclass.nonStaticMethod();

        // No need to have outer class reference to access static class's static
        // method.
        StaticClass.staticMethod();

        StaticAndNonStaticClass instance = new StaticAndNonStaticClass();
        StaticAndNonStaticClass.NonStaticClass nsclass = instance.new NonStaticClass();
        nsclass.nonStaticMethod();

    }

}
