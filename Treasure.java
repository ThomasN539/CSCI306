package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Treasure extends GamePiece implements Drawable{
	//Below are all the variables that make up treasure
	private char treasureSymbol;
	private String treasureLabel;
	private int treasureLocation;

	//This is the constructor
	public Treasure(char symbol, String label, int location) {
		super(symbol, label, location);
		treasureSymbol = symbol; 
		treasureLabel = label;
		treasureLocation = location;
	}
	//If the player lands on treasure then display the treasure message and advance the player to the next level. 
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == treasureLocation) {
			System.out.println(treasureLabel);
			return InteractionResult.ADVANCE;
		}
		else return InteractionResult.NONE;

	}
}
