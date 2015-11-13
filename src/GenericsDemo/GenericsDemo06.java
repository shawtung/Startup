package GenericsDemo;

/**
 * Created by Shaw on 2015/11/12.
 */
public class GenericsDemo06 {
	public static void main(String[] args) {
		Point<String> p = new Point<>();
		p.setKey("it");
		System.out.println(p.getKey().length());
	}
}

class Point<T> {
	private T key;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}
}
