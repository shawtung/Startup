package EightQueens;

public class Queen {
	protected int x, y;

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static boolean pieceIsNotConflicted(Queen a, Queen b) {
		if (a.x == b.x || a.y == b.y || a.x - b.x - a.y + b.y == 0 || a.x - b.x - b.y + a.y == 0)
			return false;
		else
			return true;
	}
}