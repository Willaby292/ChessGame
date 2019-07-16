package src;

public class Pawn extends Piece {

	int xVal;
	int yVal;
	int[] locaton = { xVal, yVal };
	Boolean player;
	Boolean hasMoved = false;

	public Pawn(int xVal, int yVal, Boolean player) {
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
			System.out.println("Illegal Pawn Move");
		}
		}
	
	@Override
	Boolean isLegalMove(BoardArray board, int newXVal, int newYVal) {// pawns can move backwards
		if(player) { //white pawn moves
			if(xVal == newXVal) {
				if(board.isEmptySpot(newXVal, newYVal)) { /*something in the way */
					if(yVal - 1 == newYVal) {
					return true;
					}
				}
			}else {
				if(!board.isEmptySpot(newXVal, newYVal)) { //
					if((yVal - 1 == newYVal) && (xVal - 1 == newXVal)){
						return true;
					}
					if((yVal - 1 == newYVal) && (xVal + 1 == newXVal)) {
						return true;
					}
				}
			}
		}
		if(xVal == newXVal) {
			if(board.isEmptySpot(newXVal, newYVal)) { /*something in the way */
				if(yVal + 1 == newYVal) {
				return true;
				}
			}
		}else {
			if(!board.isEmptySpot(newXVal, newYVal)) { //
				if((yVal + 1 == newYVal) && (xVal - 1 == newXVal)){
					return true;
				}
				if((yVal + 1 == newYVal) && (xVal + 1 == newXVal)) {
					return true;
				}
			}
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
			return " pawnW  ";
		}
		return " pawnB  ";
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
