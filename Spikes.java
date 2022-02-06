package levelPieces;
import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Spikes extends GamePiece implements Drawable{
	private char spikeSymbol;
	private String spikeLabel;
	private int spikeLocation;
	

	public Spikes(char symbol, String label, int location) {
		super(symbol, label, location);
		spikeSymbol = symbol; 
		spikeLabel = label;
		spikeLocation = location;
	
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == spikeLocation) {
		return InteractionResult.KILL;
		}
		else return InteractionResult.NONE;
		
	}
}
