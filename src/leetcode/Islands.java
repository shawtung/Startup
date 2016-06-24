package leetcode;

public class Islands {
	/**
	 * -1是未标记陆地,0是海洋
	 * X,Y: 矩形长宽
	 */
	private int[][] plane;
	private int X;
	private int Y;

	private int count = 0;

	private boolean check() {
		for (int[] a: plane) {
			for (int b: a) {
				if (b != -1 && b != 0)
					return false;
			}
		}
		return true;
	}

	/**
	 * 遍历数组中的每个元素,对每个-1进行染色标记
	 * 每轮染色之间总数+1
	 * @return 返回小岛数量
	 */
	private int countIslands() {
		for (int i = 0; i <= Y; i++) {
			for (int j = 0; j <= X; j++) {
				if (plane[i][j] == -1) {
					count++;
					paint(j, i);
				}
			}
		}

		return count;
	}

	/**
	 * 四个方向探索,遇到未标记的陆地则在新的坐标继续染色
	 * @param x 二维坐标系的横坐标
	 * @param y 二维坐标系的纵坐标
	 */
	private void paint(int x, int y) {
		int X = plane[0].length-1;
		int Y = plane.length-1;

		plane[y][x] = count;

		if (0 <= y && y <= Y) {
			if (0 <= x-1 && x-1 <= X) {
				if (plane[y][x-1] == -1) {
					paint(x-1, y);
				}
			}

			if (0 <= x+1 && x+1 <= X) {
				if (plane[y][x+1] == -1) {
					paint(x+1, y);
				}
			}
		}

		if (0 <= x && x <= X) {
			if (0 <= y-1 && y-1 <= Y) {
				if (plane[y-1][x] == -1) {
					paint(x, y-1);
				}
			}

			if (0 <= y+1 && y+1 <= Y) {
				if (plane[y+1][x] == -1) {
					paint(x, y+1);
				}
			}
		}
	}

	private void test(int[][] arr) {
		this.plane = arr;
		X = plane[0].length-1;
		Y = plane.length-1;

		if (!check()) {
			System.err.println("数组数据错误。");
		} else {
			System.out.println("Island number: "+countIslands());
		}

	}

	public static void main(String[] args) {
		int[][] map = {
				{-0, -1, -0, -0, -0},
				{-0, -0, -1, -1, -1},
				{-0, -0, -0, -1, -0},
				{-0, -1, -1, -0, -0},
				{-0, -0, -0, -0, -0},
				{-1, -1, -1, -1, -1},
				{-1, -0, -0, -0, -1},
				{-1, -0, -1, -0, -1},
				{-1, -0, -0, -0, -1},
				{-1, -1, -1, -1, -1},
		};

		new Islands().test(map);
	}
	
}
