package levelPieces;
import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup implements Drawable, Moveable{
	protected Drawable[] gameBoard = new Drawable[21];
	public int createLevel;
	String spikeMessage = "You stepped on spikes";

	//enemy creation list initialize enemy locations, labels, and symbols. They can be used on multiple levels
	Snake snake1 = new Snake('S', "You got bit by a snake", 5);
	Snake snake2 = new Snake('S', "You got bit by a snake", 8);
	Leprechaun leprechaun1 = new Leprechaun('L', "You got some gold", 0);
	Leprechaun leprechaun2 = new Leprechaun('L', "You got some gold", 20);
	Chimp chimp1 = new Chimp('C', "The chip threw a rock at you", 3);

	//This resets the gameboard to a new Drawable with 21 squares after a level is completed. This also returns a number to signify the current level to help other programs know what to do .
	public int createLevel(int currentLevel) {
		createLevel = currentLevel;
		gameBoard = new Drawable[21];
		return currentLevel;
	}
	//Getboard will get the board for each level by placing the game pieces on certain squares. 
	public Drawable[] getBoard() {
		//These are where the pieces are initialized on level one 
		if (createLevel == 1) {
			//For loop generates grass on first 5 steps 4
			for (int i = 0; i < 5; i++) {
				gameBoard[i] = new Grass('G');
			}
			gameBoard[5] = new Snake('S', "You got bit by a snake", 5);
			gameBoard[17] = new Spikes('M', spikeMessage, 19);
			gameBoard[19] = new Spikes('M', spikeMessage, 17);
			gameBoard[12] = new Spikes('M', spikeMessage, 12);
			gameBoard[15] = new Spikes('M', spikeMessage, 15);
			gameBoard[20] = new Treasure('T', "You found the treasure", 20);
		}


		//These are where the pieces are initialized on level two 
		else {
			gameBoard[11] = new Spikes('M', spikeMessage, 11);
			gameBoard[13] = new Spikes('M', spikeMessage, 13);
			gameBoard[15] = new Spikes('M', spikeMessage, 15);
			gameBoard[17] = new Spikes('M', spikeMessage, 17);
			gameBoard[3] = new Chimp ('C', "The chip threw a rock at you", 3);
			gameBoard[7] = new Grass ('G');
			gameBoard[18] = new Grass ('G');
			gameBoard[8] = new Snake ('S', "You got bit by a snake", 8);
			gameBoard[0] = new Leprechaun ('L', "You got some gold", 0);
			gameBoard[20] = new Leprechaun ('L', "You got some gold", 0);
		}

		return gameBoard;
	}

	//Below are a list of moving pieces for level 1 which just includes a snake, and level 2 which has chimp, leprechauns, and snakes.
	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> moveableEntities = new ArrayList<Moveable>();
		if (createLevel == 1) {
			moveableEntities.add(snake1);
			return moveableEntities;
		}
		else {
			moveableEntities.add(snake2);
			moveableEntities.add(leprechaun1);
			moveableEntities.add(leprechaun2);
			moveableEntities.add(chimp1);
			return moveableEntities;
		}
	}

	//Below are all the interacting pieces found on level one and level 2 as well as their initial location. 
	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> gamePieces = new ArrayList<GamePiece>();
		if (createLevel == 1) {
			gamePieces.add(new Treasure('T',"You found the treasure",20));
			gamePieces.add(new Spikes('M', spikeMessage, 19));
			gamePieces.add(new Spikes('M', spikeMessage, 17));
			gamePieces.add(new Spikes('M', spikeMessage, 12));
			gamePieces.add(new Spikes('M', spikeMessage, 15));
			gamePieces.add(snake1);
		}
		else if (createLevel == 2) {
			gamePieces.add(new Spikes('M', spikeMessage, 13));
			gamePieces.add(new Spikes('M', spikeMessage, 11));
			gamePieces.add(new Spikes('M', spikeMessage, 15));
			gamePieces.add(new Spikes('M', spikeMessage, 17));
			gamePieces.add(leprechaun1);
			gamePieces.add(leprechaun2);
			gamePieces.add(chimp1);
			gamePieces.add(snake2);

		}
		return gamePieces;		
	}

	//The player starts in the center of the board 
	public int getPlayerStartLoc() {
		return 10;
	}


	@Override
	//Actual move functions exist in specific pieces rather than here since each piece has unique movement
	public void move(Drawable[] gameBoard, int playerLocation) {
	}

	@Override
	public void draw() {
	}

}
