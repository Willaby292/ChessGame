package src;

import java.util.Arrays;

public class GameBoard {

	int boardSize;
	public BoardArray board;
	int pawnStartRowB = 1;
	int pawnStartRowW = 6;
	int majorStartRowB = 0;
	int majorStartRowW = 7;
	Boolean turn = true;

	public GameBoard(int boardSize) {
		this.boardSize = boardSize;
		this.board = new BoardArray(boardSize);
	}

	// place pieces in starting position
	private void populateBoard() {
		populatePawns();
		populateRooks();
		populateKnights();
		populateBishops();
		populateKings();
		populateQueens();
	}

	public void gameStart() {
		populateBoard();
		printBoard();
	}

	public void populatePawns() {
		for (int x = 0; x < boardSize; x++) {
			Pawn pawn = new Pawn(x, pawnStartRowB, false);
			board.setPiece(pawn, x, pawnStartRowB);
		}
		for (int x = 0; x < boardSize; x++) {
			Pawn pawn = new Pawn(x, pawnStartRowW, true);
			board.setPiece(pawn, x, pawnStartRowW);
		}
	}

	public void populateRooks() {
		for (int x = 0; x < boardSize; x += 7) {
			Rook rook = new Rook(x, majorStartRowB, false);
			board.setPiece(rook, x, majorStartRowB);
		}
		for (int x = 0; x < boardSize; x += 7) {
			Rook rook = new Rook(x, majorStartRowW, true);
			board.setPiece(rook, x, majorStartRowW);
		}
	}

	public void populateKnights() {
		for (int x = 1; x < boardSize; x += 5) {
			Knight knight = new Knight(x, majorStartRowB, false);
			board.setPiece(knight, x, majorStartRowB);
		}
		for (int x = 1; x < boardSize; x += 5) {
			Knight knight = new Knight(x, majorStartRowW, true);
			board.setPiece(knight, x, majorStartRowW);
		}
	}

	public void populateBishops() {
		for (int x = 2; x < boardSize; x += 3) {
			Bishop bishop = new Bishop(x, majorStartRowB, false);
			board.setPiece(bishop, x, majorStartRowB);
		}
		for (int x = 2; x < boardSize; x += 3) {
			Bishop bishop = new Bishop(x, majorStartRowW, true);
			board.setPiece(bishop, x, majorStartRowW);
		}
	}

	public void populateKings() {
		King kingB = new King(4, majorStartRowB, false);
		board.setPiece(kingB, 4, majorStartRowB);

		King kingW = new King(4, majorStartRowW, true);
		board.setPiece(kingW, 4, majorStartRowW);
	}

	public void populateQueens() {
		Queen queenB = new Queen(3, majorStartRowB, false);
		board.setPiece(queenB, 3, majorStartRowB);

		Queen queenW = new Queen(3, majorStartRowW, true);
		board.setPiece(queenW, 3, majorStartRowW);
	}

	public void moveGamePiece(int xVal, int yVal, int newXVal, int newYVal) {
		if (board.getPiece(xVal, yVal) != null) {
			Piece movingPiece = board.getPiece(xVal, yVal);
			// if (movingPiece.getPlayer() == turn) {

			if (movingPiece.isLegalMove(board, newXVal, newYVal)) {
				board.setPiece(null, xVal, yVal);
			}

			movingPiece.movePiece(board, newXVal, newYVal);
			board.setPiece(movingPiece, movingPiece.getXVal(), movingPiece.getYVal());

			if (movingPiece instanceof Pawn) {
				if (newYVal == 0 || newYVal == 7) {
					Queen queen = new Queen(newXVal, newYVal, movingPiece.getPlayer());
					board.setPiece(queen, newXVal, newYVal);

				}
			}

			if (turn) {
				turn = false;
			} else {
				turn = true;
			}
			// }else {
			// System.out.println(" Wrong Turn");
			// }
		}

		printBoard();
	}

	private void printBoard() {
		System.out.println(board.toString());
	}

}
