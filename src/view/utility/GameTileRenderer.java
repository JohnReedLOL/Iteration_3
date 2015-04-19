package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import javax.imageio.ImageIO;

import application.Application;
import model.MapObject;
import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public class GameTileRenderer extends TileRenderer {

	// Tile images
	private BufferedImage grass;
	private BufferedImage mountain;
	private BufferedImage water;

	// SIZE
	private final int HEXAGON_SIZE = 100;

	// MapObjectsRenderer
	private GameObjectRenderer mapObjectRenderer;

	// FOR DEBUG
	private final boolean DEBUG = true;

	public GameTileRenderer(Graphics g) {
		super(g);
		mapObjectRenderer = new GameObjectRenderer(g);

		try {
			System.out.println();
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			URL url = classLoader.getResource("resources/png/grass.png");
			grass = ImageIO.read(new File(url.getPath()));
			url = classLoader.getResource("resources/png/mountain.png");
			mountain = ImageIO.read(new File(url.getPath()));
			url = classLoader.getResource("resources/png/water.png");
			water = ImageIO.read(new File(url.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	public void visit(GrassTile grassTile) {
		drawTileAlgorithm(grass, grassTile.getMapObjects());
	}

	public void visit(MountainTerrain mountainTerrain) {
		drawTileAlgorithm(mountain, mountainTerrain.getMapObjects());
	}

	public void visit(WaterTile waterTile) {
		drawTileAlgorithm(water, waterTile.getMapObjects());
	}

	private void drawTileAlgorithm(Image img, Collection<MapObject> mapObjects) {
		scaleXandY(x, y);
		g.drawImage(img, drawx, drawy, 100, 100, null);
		drawMapObjects(mapObjects);
		drawDebug();
	}

	private void drawMapObjects(Collection<MapObject> mapObjects) {
		for (MapObject mapObject : mapObjects) {
			//mapObject.accept(mapObjectRenderer);
		}
	}

	private void drawDebug() {
		if (DEBUG) {
			g.setColor(Color.RED);
			g.drawRect(drawx, drawy, 100, 100);
			g.drawString("x: " + x + ",y: " + y, drawx, drawy);
		}
	}

}
