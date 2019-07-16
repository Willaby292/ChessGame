package src;

import java.util.Arrays;

public class BoardArray {

	Piece[][] boardArrayPieces;
	int boardSize;

	public BoardArray(int boardSize) {
		boardArrayPieces = new Piece[boardSize][boardSize];
		this.boardSize = boardSize;
	}

	public Piece[][] getArray() {
		return boardArrayPieces;
	}

	public Piece getPiece(int xVal, int yVal) {
		return boardArrayPieces[xVal][yVal];
	}
	
	public Boolean isEmptySpot(int xVal, int yVal) {
		if(boardArrayPieces[xVal][yVal] != null) {
			return false;
		}
		return true;
	}

	public void setPiece(Piece piece, int xVal, int yVal) {
		boardArrayPieces[xVal][yVal] = piece;
	}

	@Override
	public String toString() {
		String string = "";
		for (int y = 0; y < boardSize; y++) {
			for(int x = 0; x < boardSize; x++) {
				if(boardArrayPieces[x][y] == null) {
				string = string + " Empty  ";
				}else {
				string = string + boardArrayPieces[x][y].toString();
				}
			}
			string = string + "\n";
		}
		return string;
	}

}
