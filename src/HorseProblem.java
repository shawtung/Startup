import java.util.ArrayList;

/**
 * Created by Shaw on 2016/2/14.
 */
public class HorseProblem {
	public static final int N_X = 6, N_Y = 6;
	public static int[] stepX = {1, 2, 2, 1, -1, -2, -2, -1};
	public static int[] stepY = {2, 1, -1, -2, -2, -1, 1, 2};
	public static ArrayList<Point> route = new ArrayList<>();
	public static int k = 0;

	public static void main(String[] args) {
		new HorseProblem().self(0, 0, 1);
	}

	public void self(int x, int y, int count) {
		Point[] p = new Point[8];
		route.add(new Point(x, y));

		if (count == N_X * N_Y) {
			System.out.print(Integer.toString(++k) + " ");
			for (int j = 0; j < N_X * N_Y; j++) {
				System.out.print(route.get(j));
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < 8; i++) {
			p[i] = new Point(x + stepX[i], y + stepY[i]);
			if (check(p[i])) {
				self(p[i].x, p[i].y, count + 1);
				route.remove(count);
			}
		}
	}

	public boolean check(Point p) {
		if (0 > p.x || p.x > N_X - 1 || 0 > p.y || p.y > N_Y - 1) {
			return false;
		}

		for (int i = 0; i < route.size(); i++) {
			if ((p.x == route.get(i).x) && (p.y == route.get(i).y)) {
				return false;
			}
		}
		return true;
	}

	class Point {
		public int x;
		public int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
		}
	}
}
