class Dog {
	public String key;


	Dog(String key) {
		this.key = key;
	}

	public void shout() {
		System.out.println("wwwww" + key);
	}
}

@SuppressWarnings("all")
class Basenji extends Dog {
	public String key;

	Basenji(String key) {
		super(key+key);
		this.key = key;
	}

	@Override
	public void shout() {
		System.out.println("ooooo" + key);
	}
}

@SuppressWarnings("all")
class Bark {
	public static void main(String args[]) {
		Dog a = new Basenji("- -a");
		Basenji b = (Basenji) a;
		Dog c = (Basenji) a;
		Basenji d = (Basenji) c;

		a.shout();
		b.shout();
		c.shout();
		d.shout();

		Dog z = new Dog("hehe?");
		z.shout();

/*
		Dog e = new Dog("this is e dog");
		Basenji f = (Basenji) e;
		f.shout();
*/





		int i = (int) 1.1;
		System.out.println(i);
		double j = i;
		System.out.println(j);
	}
}