import java.util.Comparator;


/**
 * Created by Shaw on 2015/12/7.
 */


public class TestProgram {

	public static <T> T findMax(T[] arr, Comparator<? super T> cmp) {
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (cmp.compare(arr[i], arr[maxIndex]) >0) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}

	public static void main(String[] args) {
		String[] arr = {"ZEBRA", "alligator", "crocodile"};
		System.out.println(findMax(arr, new CaseInsensitiveCompare()));

		double d = 0;
		for (int i = 0; i < 10000; i++) {
			d += 1 / Math.pow(4, i);
		}
		System.out.println(d * 3);
	}

}

class CaseInsensitiveCompare implements Comparator<String> {
	public int compare(String lhs, String rhs) {
		return lhs.compareToIgnoreCase(rhs);
	}
}


