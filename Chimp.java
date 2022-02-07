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

	public int getChimpLocation() {
		return chimpLocation;
	}
	public void setChimpLocation(int chimpLocation) {
		this.chimpLocation = chimpLocation;
	}
	public void setChimpLabel(String chimpLabel) {
		this.chimpLabel = chimpLabel;
	}

	public Chimp(char symbol, String label, int location) {
		super(symbol, label, location);
		chimpLocation = location;
		chimpLabel = label;
	
	}
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		int distance = Math.abs(playerLocation - chimpLocation);
		System.out.println(distance);
		int chimpChoice;
		if (distance <= 2) {
		Random randomNum = new Random();
		chimpChoice = randomNum.nextInt(15);
		if (chimpChoice <= 5) {
			System.out.println("The chimp threw a rock at you");
			return InteractionResult.HIT;
		}
		
		else if (chimpChoice == 6){
			System.out.println("The chimp threw a large stone at you");
			return InteractionResult.KILL;
		}
		else if (chimpChoice < 6 && chimpChoice > 11) {
			System.out.println("The chimp threw some twigs at you but it does no damage to you");
			return InteractionResult.NONE; 
		}
		else if (chimpChoice >= 11) {
			System.out.println("The chimp threw some gold at you");
			return InteractionResult.GET_POINT;
		}
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (getChimpLocation() == 3) {
			gameBoard[chimpLocation] = null;
			gameBoard[5] = new Chimp('C', "The chimp threw a rock at you", 5);
			setChimpLocation(5);
			System.out.println("Test");
		}
		else if (getChimpLocation() == 5) {
			gameBoard[chimpLocation] = null;
			gameBoard[6] = new Chimp('C', "The chimp threw a rock at you", 6);
			setChimpLocation(6);
		}
		else if (getChimpLocation() == 6) {
			gameBoard[chimpLocation] = null;
			gameBoard[4] = new Chimp('C', "The chimp threw a rock at you", 4);
			setChimpLocation(4);
		}
		else if (getChimpLocation() == 4) {
			gameBoard[chimpLocation] = null;
			gameBoard[3] = new Chimp('C', "The chimp threw a rock at you", 3);
			setChimpLocation(3);
		}
	}
}
