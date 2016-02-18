import java.math.BigDecimal;

/**
 * Created by Shaw on 2016/2/1.
 */
public class Binary {
	public static String toBinary(int d) {
		StringBuffer sb = new StringBuffer("0.");
		for (int i = 0; i < 276; i++) {
			d = d*2;
			if (d > 100) {
				d = d-100;
				sb.append("1");
			} else if (d == 100) {
				sb.append("1");
				break;
			} else if (d < 100) {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	public static BigDecimal binaryChange(BigDecimal a) {
		StringBuffer s = new StringBuffer(a.toString());
		for (int i = s.length()-1; i > 1; i--) {
			if (s.charAt(i) > '1') {
				char tmp = s.charAt(i);
				s.deleteCharAt(i);
				s.insert(i, (char)(tmp-2));

				tmp = s.charAt(i-1);
				s.deleteCharAt(i-1);
				s.insert(i-1, (char)(tmp+1));
			}
		}
		return new BigDecimal(s.toString());
	}

	public static void main(String[] args) {

		System.out.println(toBinary(1));
		System.out.println(toBinary(6));
		System.out.println(toBinary(7));
		BigDecimal bigDecimal1 = new BigDecimal(toBinary(1));
		BigDecimal bigDecimal2 = new BigDecimal(toBinary(6));
		BigDecimal bigDecimal3 = bigDecimal1.add(bigDecimal2);
		System.out.println(binaryChange(bigDecimal3));
		System.out.println(toBinary(7).equals(binaryChange(bigDecimal3).toString()));

		System.out.println(0.01+0.06);
		System.out.println(0.01+0.05);

//		System.out.println(toBinary(0.060000000000000005));

//		System.out.println((0.01+0.05)*100);
//		System.out.println((0.01+0.05));
//		System.out.println(0.0600_0000_0000_0000_05);
	}
}
