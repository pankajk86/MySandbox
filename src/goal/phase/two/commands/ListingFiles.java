package goal.phase.two.commands;

import java.io.File;

public class ListingFiles {

    public static void main(String[] args) {

        File file = new File(System.getProperty("user.dir"));
        System.out.println("Current Location: " + file.getPath());

        for (String child : file.list()) {
            System.out.println(child);
        }

        // recursive call, i.e. ls -r
        // listFiles(file, 0);
    }

    /**
     * Recursive listing of the files
     * 
     * @param parent
     * @param level
     */
    @SuppressWarnings("unused")
    private static void listFiles(File parent, int level) {
        for (String child : parent.list()) {

            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }

            System.out.println(child);
            File file = new File(parent.getPath() + "/" + child);

            if (file.isDirectory()) {
                listFiles(file, level + 1);
            }
        }
    }

}
