import java.io.*;

/**
 * Created by Shaw on 2015/9/15.
 */
public class TestBufferStream2 {

    public static void main(String[] args) {
        try {
            File file = new File("d:/1.txt");
            file.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String s;
            for (int i = 1; i <= 100; i++) {
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            bw.close();
            br.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
