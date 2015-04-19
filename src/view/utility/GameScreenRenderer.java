package view.utility;

import java.awt.Graphics;

public abstract class GameScreenRenderer extends Renderer {

	// SIZE
	protected final int HEXAGON_SIZE = 100;
	
	public GameScreenRenderer(Graphics g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void scaleXandY(int x, int y) {
		/**
		 * Tile[x][y]
		 * for a Game map the first index is the x and the second index is y
		 *   ____      ____ 
		 *  / 0,0\____/ 0,2\   x,y
		 *  \____/ 0,1\____/
		 *  / 1,0\____/ 1,2\
		 *  \____/ 1,1\____/
		 *  / 2,0\____/ 2,2\
		 *  \____/    \____/
		 *  
		 *  BECAUSE OF THIS, we need to translate the Tile indexes x and y
		 *  to the scaled drawx and drawy for the Graphics
		 */
		drawx = startx + y * HEXAGON_SIZE * 3 / 4;
		int yoffset = (int) (Math.sin(Math.PI*2/3) * (HEXAGON_SIZE / 2));
		drawy = starty + 2 * yoffset * x;
		if (y % 2 != 0) {
			drawy += yoffset;
		}
	}

}
