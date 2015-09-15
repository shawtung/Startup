import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Shaw on 2015/9/14.
 */
public class TestCopy {
    public static void main(String[] args) {
        int b;
        FileInputStream in;
        FileOutputStream out;

        try {
            in = new FileInputStream("d:/io.dat");
            out = new FileOutputStream("d:/iobak.dat");
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (FileNotFoundException FNFEe) {
            System.out.println("File Not Found");
            FNFEe.printStackTrace();
            System.exit(-1);
        } catch (IOException IOe) {
            System.out.println("IO Error");
            IOe.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Done");
    }
}
