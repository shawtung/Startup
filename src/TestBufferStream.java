import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Shaw on 2015/9/14.
 */
public class TestBufferStream {

    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("d:/io.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int c;
            System.out.println(bis.read());
            System.out.println(bis.read());
            bis.mark(100);
            for (int i = 0; i <= 15 && (c = bis.read()) != -1; i++) {
                System.out.print((char)c +" ");
            }
            System.out.println();
            bis.reset();
            for (int i = 0; i <= 15 && (c = bis.read()) != -1 ; i++) {
                System.out.print(c + " ");
            }
            bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

}
