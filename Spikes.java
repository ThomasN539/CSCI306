package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Spikes extends GamePiece implements Drawable{
	//Below are the variables that make up Spikes
	private char spikeSymbol;
	private String spikeLabel;
	private int spikeLocation;

	//Below is the constructor
	public Spikes(char symbol, String label, int location) {
		super(symbol, label, location);
		spikeSymbol = symbol; 
		spikeLabel = label;
		spikeLocation = location;

	}
	//If the player lands on spikes then they will get killed. 
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == spikeLocation) {
			System.out.println(spikeLabel);
			return InteractionResult.KILL;
		}
		else return InteractionResult.NONE;

	}
}
