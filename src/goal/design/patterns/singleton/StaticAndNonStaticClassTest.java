package goal.design.patterns.singleton;

public class StaticAndNonStaticClassTest {

    public static void main(String[] args) {
        StaticAndNonStaticClass.StaticClass sclass = new StaticAndNonStaticClass.StaticClass();
        sclass.staticMethod();

        StaticAndNonStaticClass instance = new StaticAndNonStaticClass();
        StaticAndNonStaticClass.NonStaticClass nsclass = instance.new NonStaticClass();
        nsclass.nonStaticMethod();

    }

}
