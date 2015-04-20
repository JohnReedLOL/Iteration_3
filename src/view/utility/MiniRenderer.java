package view.utility;

import java.awt.Graphics;

public abstract class MiniRenderer extends Renderer {

	protected final int SIZE_OF_MAP_PIXEL = 20;
	
	public MiniRenderer(Graphics g) {
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
		 *  
		 *  For minimap, we will display as squares like so
		 *   ____      ____ 
		 *  | 0,0|____| 0,2|   x,y
		 *  |____| 0,1|____|
		 *  | 1,0|____| 1,2|
		 *  |____| 1,1|____|
		 *  | 2,0|____| 2,2|
		 *  |____|    |____|
		 */
		drawx = startx + (y) * SIZE_OF_MAP_PIXEL;
		drawx -= avatary*SIZE_OF_MAP_PIXEL;
		if (y % 2 != 0) {
			drawy = starty + (x) * SIZE_OF_MAP_PIXEL + SIZE_OF_MAP_PIXEL/2;
		} else {
			drawy = starty + (x) * SIZE_OF_MAP_PIXEL;
		}
		if (avatary % 2 != 0){
			drawy -= ((avatarx)*SIZE_OF_MAP_PIXEL+SIZE_OF_MAP_PIXEL/2);
		} else {
			drawy -= (avatarx)*SIZE_OF_MAP_PIXEL;
		}
	}
	

}
