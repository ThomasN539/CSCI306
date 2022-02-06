package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup implements Drawable, Moveable{
	protected Drawable[] gameBoard = new Drawable[21];
	public int createLevel;
	
	//enemy creation list to specify where they start off with
	Snake snake1 = new Snake('S', "You got bit by a snake", 5);
	Snake snake2 = new Snake('S', "You got bit by a snake", 8);
	Leprechaun leprechaun1 = new Leprechaun('L', "You got some gold", 0);
	Leprechaun leprechaun2 = new Leprechaun('L', "You got some gold", 20);
	Chimp chimp1 = new Chimp('C', "The chip threw a rock at you", 3);
	
	
	public int createLevel(int currentLevel) {
		createLevel = currentLevel;
		gameBoard = new Drawable[21];
		return currentLevel;
	}
	
	public Drawable[] getBoard() {
		//These are where the pieces are initialized on level one 
		if (createLevel == 1) {
		gameBoard[1] = new Leprechaun('L', "You got some gold", 1);
		gameBoard[5] = new Snake('S', "You got bit by a snake", 5);
		gameBoard[17] = new Spikes('M', "You were killed by spikes", 19);
		gameBoard[19] = new Spikes('M', "You were killed by spikes", 17);
		gameBoard[20] = new Treasure('T', "You found the treasure", 20);
		}
		
		
		//These are where the pieces are initialized on level two 
		else {
		//Leprechaun will move on square 0 or 1 and will move on squares 19 and 20 
		//spikes will be on 11, 13, 15, 17
		//snake will move 7,8,9,8,9,8,9,8,9
		gameBoard[11] = new Spikes('M', "Test", 11);
		gameBoard[13] = new Spikes('M', "Test", 13);
		gameBoard[15] = new Spikes('M', "Test", 15);
		gameBoard[17] = new Spikes('M', "Test", 17);
	    gameBoard[3] = new Chimp ('C', "Test", 3);
	    gameBoard[8] = new Snake ('S', "Test", 8);
	    gameBoard[0] = new Leprechaun ('L', "Test", 0);
	    gameBoard[20] = new Leprechaun ('L', "Test", 0);
		}
		
		return gameBoard;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> moveableEntities = new ArrayList<Moveable>();
		if (createLevel == 1) {
		moveableEntities.add(snake1);
		return moveableEntities;
		}
		else {
			moveableEntities.add(snake2);
			return moveableEntities;
		}
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> gamePieces = new ArrayList<GamePiece>();
		if (createLevel == 1) {
		gamePieces.add(new Treasure('X',"Test",20));
		gamePieces.add(new Spikes('M', "Test", 19));
		gamePieces.add(new Spikes('M', "Test", 17));
		gamePieces.add(snake1);
		gamePieces.add(leprechaun1);
		}
		else if (createLevel == 2) {
		gamePieces.add(new Spikes('M', "Test", 13));
		gamePieces.add(new Spikes('M', "Test", 11));
		gamePieces.add(new Spikes('M', "Test", 15));
		gamePieces.add(new Spikes('M', "Test", 17));
		gamePieces.add(leprechaun1);
		gamePieces.add(leprechaun2);
		gamePieces.add(chimp1);
		gamePieces.add(snake2);
		
		}
		return gamePieces;		
	}
	
	public int getPlayerStartLoc() {
		return 10;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}

	@Override
	public void draw() {
	}

}
