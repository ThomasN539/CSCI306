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
	//The chimp has a range of 2 and can perform all interactions but advance with a random random number generator choose what it does 
	//Chances: 1/15 Kill, 6/15 hit, 4/15 None, 4/15 = Get_Point. 
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		int distance = Math.abs(playerLocation - chimpLocation);
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

	//The chimp has a range of being in locations between 3 and 6. If the chimp is between 3 and 6 it has a 50% chance of moving left and a 50% chance 
	//of moving right. If the chimp is at the edges 3 or 6 then it will move inwards from 3 to 4 or 6 to 5. 
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random randomNum = new Random();
		int chimpChoice2 = randomNum.nextInt(2);
		if (getChimpLocation() == 3) {
			gameBoard[chimpLocation] = null;
			gameBoard[4] = new Chimp('C', "The chimp threw a rock at you", 4);
			setChimpLocation(4);
		}
		else if (getChimpLocation() < 6 || getChimpLocation() > 3) {
			if (chimpChoice2 == 0) {
				gameBoard[chimpLocation] = null;
				gameBoard[getChimpLocation() - 1] = new Chimp('C', "The chimp threw a rock at you", getChimpLocation() - 1);
				setChimpLocation(getChimpLocation() - 1);
			}
			else if (chimpChoice2 == 1) {
				gameBoard[chimpLocation] = null;
				gameBoard[getChimpLocation() + 1] = new Chimp('C', "The chimp threw a rock at you", getChimpLocation() + 1);
				setChimpLocation(getChimpLocation() + 1);
			}
		}
		else if (getChimpLocation() == 6) {
			gameBoard[chimpLocation] = null;
			gameBoard[5] = new Chimp('C', "The chimp threw a rock at you", 5);
			setChimpLocation(5);
		}
	}
}
