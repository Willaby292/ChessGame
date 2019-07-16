package src;

public abstract class Piece {
	int xVal;
	int yVal;
	Boolean hasMoved = false;
	
	abstract void movePiece(BoardArray board, int newXVal, int newYVal);
	
	abstract Boolean getPlayer();
	
	abstract Boolean isCaptured();
	
	abstract void capture();
	
	abstract int getXVal();
	
	abstract int getYVal();

	abstract Boolean isLegalMove(BoardArray board, int newXVal, int newYVal);
	
	abstract Boolean hasMoved();

	abstract void setXVal(int newXVal);

	abstract void setYVal(int newYVal);
	

	}
