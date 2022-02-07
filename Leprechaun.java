package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Leprechaun extends GamePiece implements Drawable, Moveable{
	private int leprechaunLocation;
	private String leprechaunLabel;
	private Boolean recieved = false;
	public Boolean getRecieved() {
		return recieved;
	}

	public void setRecieved(Boolean recieved) {
		this.recieved = recieved;
	}

	public String getLeprechaunLabel() {
		return leprechaunLabel;
	}

	public int getLeprechaunLocation() {
		return leprechaunLocation;
	}

	public void setLeprechaunLocation(int leprechaunLocation) {
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
		if (getRecieved() == false) {
		setRecieved(true);
		return InteractionResult.GET_POINT;
		}
		else return InteractionResult.NONE;
		}
		else return InteractionResult.NONE;
	}
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (gameBoard[leprechaunLocation] == null)
		{
		}
		else if (getLeprechaunLocation() == 0) {
			gameBoard[leprechaunLocation] = null;
			gameBoard[1] = new Leprechaun('L', "You got some gold", 1);
			setLeprechaunLocation(1);
		}
		else if (getLeprechaunLocation() == 1) {
				gameBoard[leprechaunLocation] = null;
				gameBoard[0] = new Leprechaun('L', "You got some gold", 0);
				setLeprechaunLocation(0);
		}
		else if (getLeprechaunLocation() == 19) {
			gameBoard[leprechaunLocation] = null;
			gameBoard[20] = new Leprechaun('L', "You got some gold", 20);
			setLeprechaunLocation(20);
		}
		else if (getLeprechaunLocation() == 20) {
			gameBoard[leprechaunLocation] = null;
			gameBoard[19] = new Leprechaun('L', "You got some gold", 19);
			setLeprechaunLocation(19);
	}
	}
}
