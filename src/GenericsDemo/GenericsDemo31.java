package GenericsDemo;

/**
 * Created by Shaw on 2015/11/12.
 */
class Info<K, V> {
	private K key;
	private V value;

	public Info(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}
}

class Demo<S> {
	private S info;
	public Demo(S info) {
		this.info = info;
	}

	public S getInfo() {
		return this.info;
	}
}


public class GenericsDemo31 {

	public static void main(String[] args) {
		Info<String, Integer> i = new Info<>("Tom", 30);
		Demo<Info<String, Integer>> d = new Demo<>(i);
		System.out.println("一 " + d.getInfo().getKey());
		System.out.println("二 " + d.getInfo().getValue());
	}

}




















