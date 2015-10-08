import java.io.*;

/**
 * Created by Shaw on 2015/9/16.
 */
public class TestTransform1 {

    public static void main(String[] args) {
        try {
            File file = new File("D:/1.TXT");
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write("MicrosoftIBMSunAppleHp");
            System.out.println(osw.getEncoding());
            osw.close();
            osw = new OutputStreamWriter(new FileOutputStream(file, true), "latin1");
            osw.write("\r\n");
            osw.write("MicrosoftIBMSunAppleHp");
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
