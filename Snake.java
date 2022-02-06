package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Snake extends GamePiece implements Drawable, Moveable{
	private int snakeLocation;
	private String snakeLabel;
	public String getSnakeLabel() {
		return snakeLabel;
	}
	public int getSnakeLocation() {
		return snakeLocation;
	}

	public void setSnakeLocation(int snakeLocation) {
		this.snakeLocation = snakeLocation;
	}

	public Snake(char symbol, String label, int location) {
		super(symbol, label, location);
		snakeLocation = location;
		snakeLabel = label;
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == snakeLocation) {
			System.out.println(getSnakeLabel());
		return InteractionResult.HIT;
		}
		else return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (snakeLocation <= 9) {
		gameBoard[snakeLocation] = null;
		gameBoard[snakeLocation + 1] = new Snake('S', "You got bit by a snake", snakeLocation);
		setSnakeLocation(snakeLocation + 1);
		}
		else {
		gameBoard[snakeLocation] = null;
		gameBoard[snakeLocation - 1] = new Snake('S', "You got bit by a snake", snakeLocation);
		setSnakeLocation(snakeLocation - 1);
		}
	}
}
