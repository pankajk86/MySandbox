package goal.phase.two.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContentDisplay {

    public static void main(String[] args) {
        File file = new File(args[0]);
        BufferedReader br = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(file));

            if (br != null) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
