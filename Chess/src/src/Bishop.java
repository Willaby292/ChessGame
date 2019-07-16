package src;

public class Bishop extends Piece {
	int xVal;
	int yVal;
	int[] locaton = { xVal, yVal };
	Boolean player;
	Boolean hasMoved = false;

	public Bishop(int xVal, int yVal, Boolean player) {
		this.xVal = xVal;
		this.yVal = yVal;
		this.player = player;
	}

	@Override
	void movePiece(BoardArray board, int newXVal, int newYVal) {
		if (isLegalMove(board, newXVal, newYVal)) {
			xVal = newXVal;
			yVal = newYVal;
			hasMoved = true;
		} else {
			System.out.println("Illegal Bishop Move");
		}
	}

	@Override
	Boolean isLegalMove(BoardArray board, int newXVal, int newYVal) {
		// cant move through pieces
		// both x and y values must be different DONE
		// x and y values must have the same difference
		// cant land on friendly pieces

		int xDiff = Math.abs(xVal - newXVal);
		int yDiff = Math.abs(yVal - newYVal);

		if (xDiff == 0 || yDiff == 0) {
			return false;
		}
		if (board.getPiece(newXVal, newYVal) != null && board.getPiece(newXVal, newYVal).getPlayer() == player) {
			return false;
		}
		if (xDiff == yDiff) {
			if (yVal > newYVal) { // y--
				if (xVal > newXVal) { // x--
					int j = xVal - 1;
					for (int i = yVal - 1; i > newYVal; i--) {
						if (board.getPiece(j, i) != null) {
							return false;
						}
						j--;
					}
				} else { // x--
					int j = xVal + 1;
					for (int i = yVal - 1; i > newYVal; i--) {
						if (board.getPiece(j, i) != null) {
							return false;
						}
						j++;
					}
				}

			} else { // y++
				if (xVal > newXVal) { // x--
					int j = xVal - 1;
					for (int i = yVal + 1; i < newYVal; i++) {
						if (board.getPiece(j, i) != null) {
							return false;
						}
						j--;
					}
				} else { // x--
					int j = xVal + 1;
					for (int i = yVal + 1; i < newYVal; i++) {
						if (board.getPiece(j, i) != null) {
							return false;
						}
						j++;
					}
				}
			}
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
			return " bishopW";
		}
		return " bishopB";
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
