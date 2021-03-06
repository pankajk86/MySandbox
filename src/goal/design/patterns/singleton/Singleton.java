package goal.design.patterns.singleton;

public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    /**
     * If not already created, then only it will create a new instance.
     * 
     * @return Singleton instance
     */
    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // lazy instantiation
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
