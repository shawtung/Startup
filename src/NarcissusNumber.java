/**
 * Created by Shaw on 2015/10/15.
 */
public class NarcissusNumber {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			int a = i % 10;
			int b = ((i - a) / 10) % 10;
			int c = i / 100;
			if (a*a*a + b*b*b + c*c*c == i) {
				System.out.println(i);
			}
		}
	}
}
