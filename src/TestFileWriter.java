import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Shaw on 2015/9/14.
 */
public class TestFileWriter {
    public static void main(String[] args){
        FileWriter fw;
        try{
            fw =  new FileWriter("D:/bak/io.dat");
            for (int i = 0; i < 65536; i++) {
                fw.write(i);
            }
        }catch (IOException IOe){
            IOe.printStackTrace();
            System.out.println("Writing Error");
            System.exit(-1);
        }
    }


}
