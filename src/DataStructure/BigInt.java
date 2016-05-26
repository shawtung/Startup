package DataStructure;

import com.sun.deploy.util.StringUtils;

/**
 * Created by Shawtung on 5/18/16.
 */
public class BigInt {

	public static void Multiply(String a, String b) {

		int[] aArr = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			aArr[i] = (int)a.charAt(i) - 48;
		}
		int[] bArr = new int[b.length()];
		for (int i = 0; i < b.length(); i++) {
			bArr[i] = (int)b.charAt(i) - 48;
		}
		
		int aL = aArr.length;
		int bL = bArr.length;


		int[][] exp = new int[bL][aL+bL-1];
		for (int i = 0; i < bL; i++) {
			for (int j = 0; j < aL+bL-1; j++) {
				exp[i][j] = 0;
			}
		}

		for (int i = 0; i < bL ; i++) {
			for (int j = 0; j < aL; j++) {
				exp[bL-1-i][i+j] = aArr[j]*bArr[i];
			}
		}

		int[] ans = new int[aL+bL];
		ans[0] = 0;
		for (int j = 0; j < aL+bL-1; j++) {
			for (int i = 0; i < bL; i++) {
				ans[j+1] += exp[i][j];
			}
		}

		for (int i = aL+bL-1; i > 0 ; i--) {
			int temp = ans[i]/10;
			ans[i-1] += temp;
			ans[i] %= 10;
		}


		for (int i = 0; i < bL; i++) {
			for (int j = 0; j < aL+bL-1; j++) {
				System.out.print(exp[i][j]);
				System.out.print('\t');
			}
			System.out.println();
		}

		for (int i = 0; i < aL+bL; i++) {
			System.out.print(ans[i]);
			System.out.print('\t');
		}
		System.out.println();

		StringBuffer ansSb = new StringBuffer("");
		for (int i = 0; i < ans.length; i++) {
			ansSb.append(ans[i]);
		}
		System.out.println(ansSb);


	}

	public static void main(String[] args) {
		Multiply("9999999", "999999999");


	}

}
