/**
 * Created by Shaw on 2015/9/15.
 */

import java.io.*;

public class TestBufferStream2 {

    public static void main(String[] args) {

        try {
            //Declaration
            File file = new File("d:/1.txt");
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter(file);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            String s;

            //Create file
            if (!file.exists()) {
                file.createNewFile();
            }

            //Write-in contents
            for (int i = 1; i <= 100; i++) {
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }
            bw.flush();

            //Print contents
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

            //Clean-up
            bw.close();
            br.close();
            fw.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
