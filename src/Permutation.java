public class Permutation {
	public static void main(String[] args) {

		int[] num = new int[6];

		for (int i = 0; i < num.length; i++)
			num[i] = (int) (Math.random() * 10);

		print(num);

		int[] j = search(num, num.length - 2);

		if (j != null) {
			int k = num[j[0]];
			num[j[0]] = num[j[1]];
			num[j[1]] = k;

			reverse(num, j[0]);
		} else {
			reverse(num, -1);
		}		
		print(num);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int[] search(int[] a, int f) {
		int[] res = new int[2];
		if (f < 0)
			return null;

		int i = a.length - 1;

		while (i > f) {
			if (a[f] < a[i]) {
				res[0] = f;
				res[1] = i;
				return res;
			}
			i--;
		}
		return search(a, f - 1);
	}

	public static void reverse(int[] a, int ind) {
		for (int i = ind + 1; i <= (a.length + ind) / 2; i++) {
			int k = a[i];
			a[i] = a[a.length + ind - i];
			a[a.length + ind - i] = k;
		}

	}
}
