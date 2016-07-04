package goal.phase.two.commands;

import java.util.Properties;

public class CurrentWorkingDirectory {

    public static void main(String[] args) {
        String pwd = System.getProperty("user.dir");
        System.out.println("Current Working Directory: " + pwd);

        Properties properties = System.getProperties();

        for (Object p : properties.keySet()) {
            String property = p.toString();
            if (property.startsWith("user")) {
                System.out.println(property + ": " + properties.getProperty(property));
            }
        }
    }

}
