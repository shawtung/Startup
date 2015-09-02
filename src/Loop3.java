public class Loop3 {
	static final int N = 1000;
	static int[] loop = new int[N + 1];
	static int del_count = 0;
	static int mod = 0;
	static int n = N - del_count;

	public static void main(String[] args) {
		init();
		filter(mod);
	}

	public static void init() {
		for (int i = 1; i <= N; i++) {
			loop[i] = i;
		}
		print();
	}

	public static void print() {
		for (int i = 1; i < loop.length; i++) {
			if (loop[i] != 0)
				System.out.print(loop[i] + " ");
		}
		System.out.println();
	}

	public static void del(int k) {
		for (int i = k; i < loop.length - del_count - 1; i++) {
			loop[i] = loop[i + 1];
		}
		loop[loop.length - del_count - 1] = 0;
		del_count++;
	}

	public static void filter(int m) {
		for (int i = n; i >= 1; i--) {
			if (i % 3 == (3 - m) % 3) {
				del(i);
			}
		}
		mod = (n + m) % 3;
		n = N - del_count;
		print();
		if (del_count < N - 1)
			filter(mod);
	}
}
