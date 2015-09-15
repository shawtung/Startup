/**
 * Created by Shaw on 2015/9/14.
 */


import java.io.*;


public class TestCopy2 {
    public static void main(String[] args) {
        int b;
        FileReader in;
        FileWriter out;

        try {
            in = new FileReader("d:/io.dat");
            out = new FileWriter("d:/iobak.dat");
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

