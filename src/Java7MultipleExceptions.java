/**
 * Created by Shaw on 2015/10/19.
 */
public class Java7MultipleExceptions {

	public static void main(String[] args) {
		try {
			rethrow("Second");
		} catch (FirstException | SecondException | ThirdException e) {
			//以下赋值将会在编译期抛出异常，因为e是final型的
			//e = new Exception();
			System.out.println(e.getMessage());
		}
	}

	static void rethrow(String s) throws FirstException, SecondException, ThirdException {
		try {
			if (s.equals("First"))
				throw new FirstException("First");
			else if (s.equals("Second"))
				throw new SecondException("Second");
			else
				throw new ThirdException("Third");

		} catch (ThirdException e) {
			//下面的赋值没有启用重新抛出异常的类型检查功能，这是Java 7的新特性
			e = new ThirdException("asdf");
			throw e;
		}

	}

	static class FirstException extends Exception {

		public FirstException(String msg) {
			super(msg);
		}

	}

	static class SecondException extends Exception {

		public SecondException(String msg) {
			super(msg);
		}

	}

	static class ThirdException extends Exception {

		public ThirdException(String msg) {
			super(msg);
		}

	}

}