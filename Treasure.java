package levelPieces;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Treasure extends GamePiece implements Drawable{
	private char treasureSymbol;
	private String treasureLabel;
	private int treasureLocation;
	

	public Treasure(char symbol, String label, int location) {
		super(symbol, label, location);
		treasureSymbol = symbol; 
		treasureLabel = label;
		treasureLocation = location;
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == treasureLocation) {
		return InteractionResult.ADVANCE;
		}
		else return InteractionResult.NONE;
		
	}
}
