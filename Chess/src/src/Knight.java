package src;

public class Knight extends Piece {
	int xVal;
	int yVal;
	int[] locaton = { xVal, yVal };
	Boolean player;
	Boolean hasMoved = false;

	public Knight(int xVal, int yVal, Boolean player) {
		this.xVal = xVal;
		this.yVal = yVal;
		this.player = player;
	}

	@Override
	void movePiece(BoardArray board, int newXVal, int newYVal) {
		if(isLegalMove(board, newXVal, newYVal)) {
			xVal = newXVal ;
			yVal = newYVal;
			hasMoved = true;
		}else {
			System.out.println("Illegal Knight Move");
		}
	}
	
	@Override
	Boolean isLegalMove(BoardArray board, int newXVal, int newYVal) {
		int xDiff = Math.abs(xVal - newXVal);
		int yDiff = Math.abs(yVal - newYVal);
		Piece checkPiece = board.getPiece(newXVal, newYVal);

		if (checkPiece != null && checkPiece.getPlayer() == player) {
			return false;
		}
		if (xDiff == 1 && yDiff == 2) {
			return true;
		}
		if (xDiff == 2 && yDiff == 1) {
			return true;
		}

		return false;
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
			return " knightW";
		}
		return " knightB";
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
