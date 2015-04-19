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

import model.MapObject;
import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public class GameTileRenderer extends GameScreenRenderer implements TileRenderer {

	// Tile images
	private BufferedImage grass;
	private BufferedImage mountain;
	private BufferedImage water;

	// MapObjectsRenderer
	private ObjectRenderer mapObjectRenderer;

	// FOR DEBUG
	private final boolean DEBUG = true;

	public GameTileRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
		mapObjectRenderer = new GameObjectRenderer(g,startx, starty);

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
		mapObjectRenderer.setX(x);
		mapObjectRenderer.setY(y);
		for (MapObject mapObject : mapObjects) {
			mapObject.accept(mapObjectRenderer);
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
