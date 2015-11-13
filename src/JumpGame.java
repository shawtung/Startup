/**
 * Created by Shaw on 2015/10/15.
 */
public class JumpGame {

	public static boolean Jumpable(int[] ints) {
		boolean[] b = new boolean[ints.length];

		b[0] = true;
		for (int cur = 0; cur < ints.length; cur++) {
			if (b[cur]) {
				for (int i = cur + 1; i <= cur + ints[cur]; i++) {
					if (i == b.length - 1) {
						return true;
					} else {
						b[i] = true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = {2, 3, 2, 1, 0, 2, 6};
		System.out.println(JumpGame.Jumpable(a));
	}

}
