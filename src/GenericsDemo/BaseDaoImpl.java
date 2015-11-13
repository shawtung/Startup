package GenericsDemo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class A<T> {
	private T t;
	Class<T> clazz;

/*
	public A(T t) {
		this.t = t;
	}
*/
	@SuppressWarnings("unchecked")
	void doGetClass() {
		ParameterizedType genType = (ParameterizedType)getClass().getGenericSuperclass();
		System.out.println(genType);
		Type[] params = genType.getActualTypeArguments();

		clazz = (Class<T>)params[0];
		System.out.println(params[0]);
		System.out.println(clazz);
	}

	public static void main(String[] args) {
		B b = new B();
		b.doGetClass();
	}
}

class B extends A<Integer> {

}