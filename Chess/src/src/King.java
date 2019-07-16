package src;

public class King extends Piece {
	int xVal;
	int yVal;
	int[] locaton = { xVal, yVal };
	Boolean player;
	Boolean hasMoved = false;

	public King(int xVal, int yVal, Boolean player) {
		this.xVal = xVal;
		this.yVal = yVal;
		this.player = player;
	}

	@Override
	void movePiece(BoardArray board, int newXVal, int newYVal) {
		if (isLegalMove(board, newXVal, newYVal)) {
			int xDiff = newXVal - xVal;
			if(xDiff == 2) { //king side castle
				board.setPiece(board.getPiece(7, yVal), 5, yVal);
				board.setPiece(null, 7, yVal);
			}
			if(xDiff == -2) { //queen side castle
				board.setPiece(board.getPiece(0, yVal), 3, yVal);
				board.setPiece(null, 0, yVal);
			}
			
			xVal = newXVal;
			yVal = newYVal;
			hasMoved = true;

			
			// check if the player is attempting to castle can be as simple as if they
			// attempt to move the king more than one space
			// if they attempt to castle then castle here

		} else {
			System.out.println("Illegal King Move");
		}
	}

	@Override
	Boolean isLegalMove(BoardArray board, int newXVal, int newYVal) {
		int xDiff = Math.abs(xVal - newXVal);
		int yDiff = Math.abs(yVal - newYVal);

		if (board.getPiece(newXVal, newYVal) != null && board.getPiece(newXVal, newYVal).getPlayer() == player) {
			return false;
		}
		// check if castling is allowed
		if (!hasMoved) { // king hasnt moved
			if (newXVal == 2) { //queen side castle
				if (!board.getPiece(0, yVal).hasMoved()) { // king attempting castle and rook hasnt moved
					if (board.getPiece(1, yVal) != null) {
						return false;
					}
					if (board.getPiece(2, yVal) != null) {
						return false;
					}
					if (board.getPiece(3, yVal) != null) {
						return false;
					}
					return true;
				}
			}
			if(newXVal == 6) { //king side castle
				if(!board.getPiece(7, yVal).hasMoved()) {
					if (board.getPiece(5, yVal) != null) {
						return false;
					}
					if (board.getPiece(6, yVal) != null) {
						return false;
					}
					return true;
				}
			}
		}

		if (xDiff > 1 || yDiff > 1) { // can only move 1 square
			return false;
		}

		return true;
	}

	@Override
	Boolean isCaptured() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void capture() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		if (player) {
			return " kingW  ";
		}
		return " kingB  ";
	}

	@Override
	Boolean getPlayer() {
		return player;
	}

	@Override
	int getXVal() {
		return xVal;
	}

	@Override
	int getYVal() {
		return yVal;
	}

	@Override
	Boolean hasMoved() {
		return hasMoved;
	}

	@Override
	void setXVal(int newXVal) {
		xVal = newXVal;
	}

	@Override
	void setYVal(int newYVal) {
		yVal = newYVal;
	}
}
