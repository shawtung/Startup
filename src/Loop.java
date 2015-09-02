public class Loop {
	public static void main(String[] args) {
		int N = 1000, cursor = 1, index = 1;
		boolean[] loop = new boolean[N + 1];
		while (cursor / 3 < N)
			if (index == index++ != loop[index % N == 1 ? N : index % N == 0 ? N - 1 : index % N - 1])
				if (cursor == cursor++ && cursor % 3 == 1)
					loop[index % N == 1 ? N : index % N == 0 ? N - 1 : index % N - 1] = true;
		for (int j = 1; j <= N; j++)
			System.out.print(loop[j] == false ? j : "");
	}
}