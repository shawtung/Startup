public class Kids {
	public static void main(String[] args) {
		kidCircle kc = new kidCircle(500);

		kid m = kc.first.left;
		while (kc.count != 1) {
			m = m.right;
			m = m.right;
			m = m.right;
			kc.delete(m);
		}
		System.out.println(kc.first.id);

	}
}

class kid {
	int id;
	kid left;
	kid right;
}

class kidCircle {
	int count = 0;
	kid first, last;

	kidCircle(int n) {
		for (int i = 0; i < n; i++) {
			add();
		}
	}

	void add() {
		count++;
		kid k = new kid();
		k.id = count;
		if (count == 1) {
			first = last = k;
			k.left = k.right = k;
		} else {
			last.right = k;
			k.left = last;
			k.right = first;
			first.left = k;
			last = k;
		}
	}

	void delete(kid k) {
		if (count == 0) {
			return;
		} else if (count == 1) {
			first = last = null;
		} else {
			k.left.right = k.right;
			k.right.left = k.left;

			if (k == first) {
				first = k.right;
			} else if (k == last) {
				last = k.left;
			}
		}
		count--;
	}
}
