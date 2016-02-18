import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/2/8.
 */
public class Solution {
	static ArrayList<Integer> ints = new ArrayList<>();
	static ArrayList<String> al = new ArrayList<>();

	public static void main(String[] args) {
		Stream<String> s = new Solution().generateParenthesis(10).stream();
		s.forEach(System.out::println);
	}

	public ArrayList<String> generateParenthesis(int n) {
		recur(n, 1, 0);
		return al;
	}

	public void recur(int N, int level, int pos) {
		ints.add(pos);
		if (level == N) {
			StringBuilder str = new StringBuilder("");
			for (int temp = 0; temp < ints.size() * 2; temp++) {
				if (ints.indexOf(temp) != -1) {
					str.append("(");
				} else {
					str.append(")");
				}
			}
			if (judge(str.toString())) {
				al.add(str.toString());
			}
		} else {
			for (int i = pos + 1; i < 2 * N; i++) {
				recur(N, level + 1, i);
			}
		}
		ints.remove(ints.size() - 1);
	}

	public boolean judge(String tStr) {
		int balance = 0;

		for (int i = 0; i < tStr.length(); i++) {
			if (tStr.charAt(i) == '(') {
				balance++;
			} else {
				balance--;
			}
			if (balance < 0) {
				return false;
			}
		}

		return true;

	}

}
