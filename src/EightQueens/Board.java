package EightQueens;

public class Board {
	private boolean[][] board;
	private Queen[] Q;

	public Board(Queen[] q) {
		board = new boolean[9][9];
		Q = new Queen[9];
		for (int i = 1; i < q.length; i++) {
			Q[i] = q[i];
			board[q[i].y][q[i].x] = true;
		}
	}

	public void printBoard() {
		System.out.print("  ");
		for (int i = 1; i <= 8; i++) {
			System.out.print(" " + (i));
		}
		System.out.print("\n");

		for (int i = 1; i <= 8; i++) {
			System.out.print((i) + " ");
			for (int j = 1; j <= 8; j++) {
				if (board[i][j]) {
					System.out.print(" #");
				} else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
	}

	public boolean boardIsNotConflicted() {
		for (int i = 1; i <= 7; i++) {
			for (int j = i + 1; j <= 8; j++) {
				if (Q[j] != null) {
					if (!Queen.pieceIsNotConflicted(Q[i], Q[j]))
						return false;
				} else {
					break;
				}
			}
		}
		return true;
	}

}
