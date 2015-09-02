public class Loop3Copy {
	public static void main(String[] args) {
		final int N = 1000;
		boolean[] loop = new boolean[N + 1];
		int cursor = 0;
		int i = 0;

		while (cursor <= 3 * (N - 1)) {
			i++;
			if (!loop[i % N == 0 ? N : i % N]) {
				cursor++;
				if (cursor % 3 == 0)
					loop[i % N == 0 ? N : i % N] = true;
			}
		}

		for (int j = 1; j <= N; j++)
			System.out.print(loop[j] == false ? j + " " : "");
	}
}
