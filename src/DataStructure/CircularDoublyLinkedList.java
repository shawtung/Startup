package DataStructure;

public class CircularDoublyLinkedList {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node cursor;

		for (int i = 1; i <= 500; i++){
			ll.add();
		}

		cursor = ll.first.backward;

		while (ll.count != 1) {
			cursor = cursor.forward;
			cursor = cursor.forward;
			cursor = cursor.forward;
			ll.delete(cursor);
		}
		
		System.out.println(ll.first.id);

	}
}

class Node {
	int id;
	Node forward;
	Node backward;
}

class LinkedList {
	int count;
	Node first;
	Node last;

	void add() {
		Node n = new Node();
		count++;

		if (count == 1) {
			first = last = n;
			n.forward = n.backward = n;
		} else {
			last.forward = n;
			first.backward = n;
			n.backward = last;
			n.forward = first;
			last = n;
		}
		n.id = count;
	}

	void delete(Node n) {
		if (count == 0) {
			return;
		} else if (count == 1) {
			first = last = null;
		} else {
			n.forward.backward = n.backward;
			n.backward.forward = n.forward;

			if (n == last || n == first) {
				first = n.forward;
				last = n.backward;
			}
		}
		count--;
	}

}
