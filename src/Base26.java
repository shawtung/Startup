/**
 * Created by Shaw on 2015/10/12.
 */
public class Base26 {
	public static String getBase26(int n) {
		char[] buf = new char[(int)Math.floor(Math.log(25 * n + 25) / Math.log(26))];
		for (int i = buf.length - 1; i >= 0; i--) {
			buf[i] = (char)(--n % 26 +'A');
			n /= 26;
		}
		return new String(buf);
	}

/*
	public int getWidth(int n) {
		for (int i = 0; i < ; i++) {
			if (n / 26 == 0)
		}

	}
*/

	public static void main(String[] args) {
		System.out.println(Base26.getBase26(704));
	}
}
