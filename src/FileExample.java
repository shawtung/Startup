/**
 * Created by Shaw on 2015/9/16.
 */

import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        createFile();
    }



    public static void createFile() {
        File f = new File("D:/a/b/1.txt");
        try {
            f.mkdirs();
            f.createNewFile();

            System.out.println(f.getTotalSpace() / (1024 * 1024 * 1024) + "G");
            System.out.println(f.getName());
            System.out.println(f.getParent());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
