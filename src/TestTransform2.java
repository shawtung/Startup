import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shaw on 2015/9/16.
 */
public class TestTransform2 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s;
        try {
            do {
                s = br.readLine();
                if (s.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(s.toUpperCase());
            } while (s != null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
