package GenericsDemo;

/**
 * Created by Shaw on 2015/11/12.
 */
public class GenericsDemo09 {
	public static void main(String[] args) {
		Notepad<String, Integer> t;
		t = new Notepad<>();
		t.setKey("tom");
		t.setValue(20);
		System.out.println(t.getKey() + t.getValue());
	}
}

class Notepad<K, V> {
	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setKey(K key) {
		this.key = key;
	}



}
