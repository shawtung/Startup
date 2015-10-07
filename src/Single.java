/**
 * Created by Shaw on 2015/10/7.
 */
public class Single {
	private static Single ourInstance = new Single();

	public static Single getInstance() {
		return ourInstance;
	}

	private Single() {
	}
}
