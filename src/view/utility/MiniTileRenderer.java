package view.utility;

import java.awt.Color;
import java.awt.Graphics;

import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public class MiniTileRenderer extends TileRenderer {

	// FOR DEBUG
	private final boolean DEBUG = false;
	
	private final int SIZE_OF_MAP_PIXEL = 10;
	
	
	public MiniTileRenderer(Graphics g) {
		super(g);
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
		drawx = startx + y * SIZE_OF_MAP_PIXEL;
		if (y % 2 == 0) {
			drawy = starty + x * SIZE_OF_MAP_PIXEL;
		} else {
			drawy = starty + x * SIZE_OF_MAP_PIXEL + SIZE_OF_MAP_PIXEL/2;
		}
	}
	
	@Override
	public void visit(WaterTile waterTile) {
		scaleXandY(x, y);
		g.setColor(Color.BLUE);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawDebug();
	}

	@Override
	public void visit(GrassTile grassTile) {
		scaleXandY(x, y);
		g.setColor(Color.GREEN);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawDebug();
		
	}

	@Override
	public void visit(MountainTerrain mountainTile) {
		scaleXandY(x, y);
		g.setColor(Color.GRAY);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawDebug();
		
	}

	private void drawDebug() {
		if (DEBUG) {
			g.setColor(Color.RED);
			g.drawRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
			g.drawString("x: " + x + ",y: " + y, drawx, drawy);
		}
	}


}
