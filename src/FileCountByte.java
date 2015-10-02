import java.io.*;

/**
 * Created by Shaw on 2015/9/16.
 */
public class FileCountByte {

    public static void main(String[] args) {
        int count = 0;
        int k = 0;
        final File file = new File("d:/OrderQuery.rar");
        byte[] b = new byte[500];

        try {
            FileInputStream fis = new FileInputStream(file);
            while (k != -1) {
                count += k;
                k = fis.read(b);
            }
            System.out.println(count);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
