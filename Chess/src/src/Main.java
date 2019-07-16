package src;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import java.util.Scanner;

public class Main extends Application{
	static GameBoard board = new GameBoard(8);
	GridPane root = new GridPane();
	static Boolean gameOver = false;
    final int size = 8;
	
	public static void main(String args[]) {
		launch(args);
		
		board.gameStart();
		while(!gameOver) {
		Scanner in = new Scanner(System.in);
		int xVal = in.nextInt();
        int yVal = in.nextInt();
        int newXVal = in.nextInt();
        int newYVal = in.nextInt();
		board.moveGamePiece(xVal, yVal, newXVal, newYVal);
		}
		
		
	}

	@Override
    public void start(Stage primaryStage) {
		for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if ((row + col) % 2 == 0) color = Color.WHITE;
                else color = Color.BLACK;
                square.setFill(color);
                root.add(square, col, row);
                square.widthProperty().bind(root.widthProperty().divide(size));
                square.heightProperty().bind(root.heightProperty().divide(size));
            }
        }
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
        
        
    }
    
}
