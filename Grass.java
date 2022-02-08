package levelPieces;

import gameEngine.Drawable;
//This is not a gamepiece and does nothing but appear on the map as Grass
public class Grass implements Drawable {
	private char grassSymbol = 'G';

	public Grass(char grassSymbol) {
		super();
		this.grassSymbol = grassSymbol;
	}

	@Override
	public void draw() {
		System.out.print(grassSymbol);
	}

}
