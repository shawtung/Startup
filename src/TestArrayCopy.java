public class TestArrayCopy {
	public static void main(String[] args) {
/*		
		String[] s = { "Microsoft", "IBM", "Sun", "Oracle", "Apple" };
		String[] sBak = new String[6];
		System.arraycopy(s, 0, sBak, 0, s.length);

		for (int i = 0; i < sBak.length; i++) {
			System.out.println(sBak[i] + " ");
		}
		System.out.println();
*/
		int[][] intArray = { { 1, 2 }, { 1, 2, 3 }, { 3, 4 } };
		int[][] intArrayBak = new int[3][];

		System.arraycopy(intArray, 0, intArrayBak, 0, intArray.length);
		intArrayBak[2][1] = 100;

		for (int i = 0; i < intArrayBak.length; i++) {
			for (int j = 0; j < intArrayBak[i].length; j++) {
				System.out.print(intArrayBak[i][j]+" ");
			}
			System.out.println();
		}

	}
}
