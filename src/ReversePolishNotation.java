import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by Shaw on 2016/2/17.
 */
class ReversePolishNotation {

	static ArrayList<String> AnswerSet = new ArrayList<>();

	public void evalRPN(String[] tokens) {
		Stack<Fraction> ValueStack = new Stack<>();
		Stack<String> ExpStack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];

			if (isNumeric(str)) {
				ValueStack.push(new Fraction(Integer.parseInt(str)));
				ExpStack.push(str);
			} else if (isSymbol(str)) {
				Fraction b = ValueStack.pop();
				Fraction a = ValueStack.pop();

				String sb = ExpStack.pop();
				String sa = ExpStack.pop();

				if (str.equals("+")) {
					if (a.lessThan(b)) {
						return;
					}
					ValueStack.push(a.add(b));
					ExpStack.push("("+sa+"+"+sb+")");
				} else if (str.equals("-")) {
					if (a.lessThan(b)) {
						return;
					}
					ValueStack.push(a.sub(b));
					ExpStack.push("("+sa+"-"+sb+")");
				} else if (str.equals("*")) {
					if (a.lessThan(b)) {
						return;
					}
					ValueStack.push(a.multiply(b));
					ExpStack.push("("+sa+"*"+sb+")");
				} else if (str.equals("/")) {
					if (b.dividend == 0) {
						return;
					} else {
						ValueStack.push(a.divide(b));
						ExpStack.push("("+sa+"/"+sb+")");
					}

				}
			}
		}

		if (!ValueStack.empty()) {
			if (ValueStack.pop().equals(new Fraction(24))) {
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
		return Pattern.compile("[0-9]*").matcher(s).matches();
	}

	public static boolean isSymbol(String s) {
		return Pattern.compile("[\\+\\-\\*/]").matcher(s).matches();
	}

	public void calc24(String a, String b, String c, String d) {
		if ((!isNumeric(a) && !isSymbol(a))
				|| (!isNumeric(b) && !isSymbol(b))
				|| (!isNumeric(c) && !isSymbol(c))
				|| (!isNumeric(d) && !isSymbol(d))) {
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
						/*
							ab~c~d~ ((a~b)~c)~d
							ab~cd~~ (a~b)~(c~d)
							abc~~d~ (a~(b~c))~d
							abcd~~~ a~(b~(c~d))
							abc~d~~ a~((b~c)~d)
						 */

						String[] ExpArr1 = {NumArr[l][0], NumArr[l][1], symbol[i], NumArr[l][2], symbol[j], NumArr[l][3], symbol[k]};
						String[] ExpArr2 = {NumArr[l][0], NumArr[l][1], symbol[i], NumArr[l][2], NumArr[l][3], symbol[j], symbol[k]};
						String[] ExpArr3 = {NumArr[l][0], NumArr[l][1], NumArr[l][2], symbol[i], symbol[j], NumArr[l][3], symbol[k]};
						String[] ExpArr4 = {NumArr[l][0], NumArr[l][1], NumArr[l][2], NumArr[l][3], symbol[i], symbol[j], symbol[k]};
						String[] ExpArr5 = {NumArr[l][0], NumArr[l][1], NumArr[l][2], symbol[i], NumArr[l][3], symbol[j], symbol[k]};

						evalRPN(ExpArr1);
						evalRPN(ExpArr2);
						evalRPN(ExpArr3);
						evalRPN(ExpArr4);
						evalRPN(ExpArr5);
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
		new ReversePolishNotation().calc24("4","4","10","10");
	}

}

class Fraction {
	int dividend;
	int divisor;

	public static int gcd(int a, int b) {
		while (true) {
			if ((a=a%b) == 0) {
				return b;
			}
			if ((b=b%a) == 0) {
				return a;
			}
		}
	}

	public Fraction(int dividend, int divisor) {
		if (divisor == 0) {
			this.dividend = 0;
			this.divisor = 0;
		} else if (dividend == 0) {
			this.dividend = 0;
			this.divisor = 1;
		} else {
			this.dividend = dividend / gcd(dividend, divisor);
			this.divisor = divisor / gcd(dividend, divisor);
		}
	}

	public Fraction(int dividend) {
		this.dividend = dividend;
		this.divisor = 1;
	}

	public Fraction add(Fraction b) {
		return new Fraction(this.dividend*b.divisor+this.divisor*b.dividend, this.divisor*b.divisor);
	}

	public Fraction sub(Fraction b) {
		return new Fraction(this.dividend*b.divisor-this.divisor*b.dividend, this.divisor*b.divisor);
	}

	public Fraction multiply(Fraction b) {
		return new Fraction(this.dividend*b.dividend, this.divisor*b.divisor);
	}

	public Fraction divide(Fraction b) {
		return new Fraction(this.dividend*b.divisor, this.divisor*b.dividend);
	}

	@Override
	public String toString() {
		return "["+String.valueOf(this.dividend)+"/"+String.valueOf(this.divisor)+"]";
	}

	public boolean equals(Fraction b) {
			return this.dividend == b.dividend && this.divisor == b.divisor;

	}

	public boolean lessThan(Fraction b) {
		return this.dividend*b.divisor-this.divisor*b.dividend < 0;
	}

}


