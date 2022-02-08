package levelPieces;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Leprechaun extends GamePiece implements Drawable, Moveable{
	//The variables that make up leprechaun. The recieved boolean indicates whether leprechaun has been collected yet. If it has it removes that leprechaun. 
	private int leprechaunLocation;
	private String leprechaunLabel;
	private Boolean recieved = false;
	private char leprechaunSymbol;
	public Boolean getRecieved() {
		return recieved;
	}
	
	//The getters and setters for ecah variable
	public void setRecieved(Boolean recieved) {
		this.recieved = recieved;
	}

	public String getLeprechaunLabel() {
		return leprechaunLabel;
	}

	public int getLeprechaunLocation() {
		return leprechaunLocation;
	}
	public char getLeprechaunSymbol() {
		return leprechaunSymbol;
	}
	public void setLeprechaunSymbol(char leprechaunSymbol) {
		this.leprechaunSymbol = leprechaunSymbol;
	}
	public void setLeprechaunLocation(int leprechaunLocation) {
		this.leprechaunLocation = leprechaunLocation;
	}
	public void setLeprechaunLabel(String leprechaunLabel) {
		this.leprechaunLabel = leprechaunLabel;
	}
	//The Constructor
	public Leprechaun(char symbol, String label, int location) {
		super(symbol, label, location);
		leprechaunLocation = location;
		leprechaunLabel = label;
		leprechaunSymbol = symbol;

	}
	//The leprechaun will give you a point if you capture it. If it is caught then the leprechaun will be deleted from the map. 
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == leprechaunLocation) {
			System.out.println(getLeprechaunLabel());
			gameBoard[leprechaunLocation] = null;
			if (getRecieved() == false) {
				setRecieved(true);
				setLeprechaunSymbol(' ');
				return InteractionResult.GET_POINT;
			}
			else return InteractionResult.NONE;
		}
		else return InteractionResult.NONE;
	}
	@Override
	//The leprechauns appear on the edges of the board and can either move left or right. Sometimes the leprechaun stands still sometimes it moves. 
	//There is a 50% chance it moves and a 50% chance it stands still, otherwise it just moves left and right. 
	public void move(Drawable[] gameBoard, int playerLocation) {

		Random randomNum = new Random();
		int lepChoice = randomNum.nextInt(2);
		if (gameBoard[leprechaunLocation] == null)
		{
		}
		if (lepChoice == 0) {
			if (getLeprechaunLocation() == 0) {
				gameBoard[leprechaunLocation] = null;
				gameBoard[1] = new Leprechaun(getLeprechaunSymbol(), getLeprechaunLabel(), 1);
				setLeprechaunLocation(1);
			}
			else if (getLeprechaunLocation() == 1) {
				gameBoard[leprechaunLocation] = null;
				gameBoard[0] = new Leprechaun(getLeprechaunSymbol(), getLeprechaunLabel(), 0);
				setLeprechaunLocation(0);
			}
			else if (getLeprechaunLocation() == 19) {
				gameBoard[leprechaunLocation] = null;
				gameBoard[20] = new Leprechaun(getLeprechaunSymbol(), getLeprechaunLabel(), 20);
				setLeprechaunLocation(20);
			}
			else if (getLeprechaunLocation() == 20) {
				gameBoard[leprechaunLocation] = null;
				gameBoard[19] = new Leprechaun(getLeprechaunSymbol(), getLeprechaunLabel(), 19);
				setLeprechaunLocation(19);
			}
		}
	}
}
