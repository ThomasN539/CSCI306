package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Leprechaun extends GamePiece implements Drawable, Moveable{
	private int leprechaunLocation;
	private String leprechaunLabel;
	public String getLeprechaunLabel() {
		return leprechaunLabel;
	}

	public int getLeprechauneLocation() {
		return leprechaunLocation;
	}

	public void setLeprechaunLocation(int snakeLocation) {
		this.leprechaunLocation = leprechaunLocation;
	}
	public void setLeprechaunLabel(String leprechaunLabel) {
		this.leprechaunLabel = leprechaunLabel;
	}

	public Leprechaun(char symbol, String label, int location) {
		super(symbol, label, location);
		leprechaunLocation = location;
		leprechaunLabel = label;
	
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == leprechaunLocation) {
		System.out.println(getLeprechaunLabel());
		gameBoard[leprechaunLocation] = null;
		return InteractionResult.GET_POINT;
		
		}
		else return InteractionResult.NONE;
	}
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}
}
