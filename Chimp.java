package levelPieces;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Chimp extends GamePiece implements Drawable, Moveable{
	private int chimpLocation;
	private String chimpLabel;
	public String getchimpLabel() {
		return chimpLabel;
	}

	public int getLeprechauneLocation() {
		return chimpLocation;
	}

	public void setLeprechaunLocation(int snakeLocation) {
		this.chimpLocation = chimpLocation;
	}
	public void setLeprechaunLabel(String leprechaunLabel) {
		this.chimpLabel = chimpLabel;
	}

	public Chimp(char symbol, String label, int location) {
		super(symbol, label, location);
		chimpLocation = location;
		chimpLabel = label;
	
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		int distance = Math.abs(playerLocation - chimpLocation);
		int chimpChoice;
		if (distance <= 2) {
		Random randomNum = new Random();
		chimpChoice = randomNum.nextInt(7);
		if (chimpChoice <= 5) {
			System.out.println("The chimp threw a rock at you");
			return InteractionResult.HIT;
		}
		else {
			System.out.println("The chimp threw some gold at you");
			return InteractionResult.GET_POINT;
		}
		}
		else return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}
}
