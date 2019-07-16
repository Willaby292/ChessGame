package src;

public class Queen extends Piece {
	int xVal;
	int yVal;
	int[] locaton = { xVal, yVal };
	Boolean player;
	Boolean hasMoved;
	
	public Queen(int xVal, int yVal, Boolean player) {
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
			System.out.println("Illegal Queen Move");
		}
	}

	@Override
	Boolean isLegalMove(BoardArray board, int newXVal, int newYVal) {
		// moves like rook and bishop

		if (board.getPiece(newXVal, newYVal) != null && board.getPiece(newXVal, newYVal).getPlayer() == player) {
			return false;
		}

		if (xVal == newXVal || yVal == newYVal) { // move like rook
			if (xVal != newXVal) {// can only move on only y axis or only x axis
				if (xVal < newXVal) {
					for (int i = xVal + 1; i < newXVal; i++) { // cant go through pieces
						if (board.getPiece(i, yVal) != null) {
							return false;
						}
					}
				} else {
					for (int i = xVal - 1; i > newXVal; i--) { // cant go through pieces
						if (board.getPiece(i, yVal) != null) {
							return false;
						}
					}

				}
			}
			if (yVal != newYVal) {
				if (yVal > newYVal) {
					for (int i = yVal - 1; i > newYVal; i--) {
						if (board.getPiece(xVal, i) != null) {
							return false;
						}
					}
				} else {
					for (int i = yVal + 1; i < newYVal; i++) {
						if (board.getPiece(xVal, i) != null) {
							return false;
						}
					}
				}
			}
			return true;
		} else { // move like bishop
			int xDiff = Math.abs(xVal - newXVal);
			int yDiff = Math.abs(yVal - newYVal);

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
	}

	@Override
	Boolean getPlayer() {
		// TODO Auto-generated method stub
		return player;
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
			return " queenW ";
		}
		return " queenB ";
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
