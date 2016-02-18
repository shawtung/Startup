import java.util.*;

class Point {
	int x;
	int y;

	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

class Quotient {
	int x;
	int y;

	Quotient(int x, int y) {
		int gcd = gcd(x, y);
		this.x = x/gcd;
		this.y = y/gcd;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Quotient) &&
				((this.x==((Quotient)o).x) && (this.y==((Quotient)o).y));
	}

	@Override
	public int hashCode() {
		return 1;
	}

	public static int gcd(int dividend, int divider) {
		int a = dividend, b = divider;
		int remainder = a%b;

		while (remainder != 0) {
			a = b;
			b = remainder;
			remainder = a%b;
		}

		return b;
	}
}

public class PointOnLine {

	public int maxPoints(Point[] points) {
		int max = 0;
		for (Point p : points) {
			Map<Quotient, Integer> map = new HashMap<>();
			for (Point pt : points) {
				if (!pt.equals(p)) {
					Quotient slope = new Quotient(p.x - pt.x, p.y - pt.y);
					if (map.containsKey(slope)) {
						map.put(slope, map.get(slope)+1);
					} else {
						map.put(slope, 1);
					}
				}
			}
			for (int i : map.values()) {
				if (i > max) {
					max = i;
				}
			}
		}
		return max+1;
	}

	public static void main(String[] args) {
		Point[] ps = { new Point(1,2), new Point(3,6), new Point(0,0), new Point(1,3) };
		System.out.println(new PointOnLine().maxPoints(ps));
	}
}
