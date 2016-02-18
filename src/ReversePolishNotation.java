import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by Shaw on 2016/2/17.
 */
class ReversePolishNotation {

	static ArrayList<String> AnswerSet = new ArrayList<>();

	public static void evalRPN(String[] tokens) {
		Stack<String> ValueStack = new Stack<>();
		Stack<String> ExpStack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];

			if (isNumeric(str)) {
				ValueStack.push(str);
				ExpStack.push(str);
			} else if (isSymbol(str)) {
				int b = Integer.parseInt(ValueStack.pop());
				int a = Integer.parseInt(ValueStack.pop());

				String sb = ExpStack.pop();
				String sa = ExpStack.pop();

				if (a < b) {
					return;
				}

				if (str.equals("+")) {
					ValueStack.push(String.valueOf(a+b));
					ExpStack.push("("+sa+"+"+sb+")");
				} else if (str.equals("-")) {
					ValueStack.push(String.valueOf(a-b));
					ExpStack.push("("+sa+"-"+sb+")");
				} else if (str.equals("*")) {
					ValueStack.push(String.valueOf(a*b));
					ExpStack.push("("+sa+"*"+sb+")");
				} else if (str.equals("/")) {
					if (b == 0 || a%b != 0) {
						return;
					}
					ValueStack.push(String.valueOf(a/b));
					ExpStack.push("("+sa+"/"+sb+")");
				}
			}
		}

		if (!ValueStack.empty()) {
			if (ValueStack.pop().equals("24")) {
				String tt = ExpStack.pop();
				String t = tt.substring(1, tt.length()-1) + " = " +24;
				if (!inArray(t)) {
					AnswerSet.add(t);
				}
			}
		}

	}

	public static boolean inArray(String s) {
		for (String t : AnswerSet) {
			if (s.equals(t)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumeric(String s) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(s).matches();
	}

	public static boolean isSymbol(String s) {
		Pattern pattern = Pattern.compile("[\\+\\-\\*/]");
		return pattern.matcher(s).matches();
	}

	public static void calc24(String a, String b, String c, String d) {
		if ((!isNumeric(a) && !isSymbol(a)) || (!isNumeric(b) && !isSymbol(b)) || (!isNumeric(c) && !isSymbol(c)) || (!isNumeric(d) && !isSymbol(d))) {
			return;
		}

		String[][] NumArr = {
				{a,b,c,d},
				{a,b,d,c},
				{a,c,b,d},
				{a,c,d,b},
				{a,d,b,c},
				{a,d,c,b},

				{b,a,c,d},
				{b,a,d,c},
				{b,c,a,d},
				{b,c,d,a},
				{b,d,a,c},
				{b,d,c,a},

				{c,a,b,d},
				{c,a,d,b},
				{c,b,a,d},
				{c,b,d,a},
				{c,d,a,b},
				{c,d,b,a},

				{d,a,b,c},
				{d,a,c,b},
				{d,b,a,c},
				{d,b,c,a},
				{d,c,a,b},
				{d,c,b,a}
		};

		String[] symbol = {"+", "-", "*", "/"};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {

					for (int l = 0; l < 24; l++) {
						String[] ExpArr1 = {NumArr[l][0], NumArr[l][1], symbol[i], NumArr[l][2], symbol[j], NumArr[l][3], symbol[k]};
						String[] ExpArr2 = {NumArr[l][0], NumArr[l][1], symbol[i], NumArr[l][2], NumArr[l][3], symbol[j], symbol[k]};

						evalRPN(ExpArr1);
						evalRPN(ExpArr2);
					}

				}
			}
		}
		if (AnswerSet.size() != 0) {
			AnswerSet.stream().forEach(System.out::println);
		} else {
			System.out.println("No Answer!");
		}

	}

	public static void main(String[] args) {
		calc24("8","3","5","9");
	}

}


