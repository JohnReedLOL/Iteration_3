package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import javax.imageio.ImageIO;

import model.MapObject;
import model.map.GameWorld;
import model.map.location.GrassTile;
import model.map.location.MountainTile;
import model.map.location.WaterTile;

public class GameTileRenderer extends GameScreenRenderer implements
		TileRenderer {

	// Tile images
	private static BufferedImage grass;
	private static BufferedImage mountain;
	private static BufferedImage water;
	private static BufferedImage dim;

	// MapObjectsRenderer
	private ObjectRenderer mapObjectRenderer;

	// FOR DEBUG
	private final boolean DEBUG = false;

	public GameTileRenderer(Graphics g, List<MapObject> mapObjects) {
		// TODO how do we set AVATAR and Location
		super(g);
		this.startx = 0;
		this.starty = 0;
		mapObjectRenderer = new GameObjectRenderer(g, mapObjects);
		initializeImages();
		// TODO fix this
		//generateViewDistanceBounds(avatarx, avatary, viewDistance);
	}

	public GameTileRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
		mapObjectRenderer = new GameObjectRenderer(g, startx, starty);
		initializeImages();
		// TODO fix this
		//generateViewDistanceBounds(avatarx, avatary, viewDistance);
	}

	private void initializeImages() {
		if (grass == null || mountain == null || water == null) {
			try {
				ClassLoader classLoader = Thread.currentThread()
						.getContextClassLoader();
				URL url = classLoader.getResource("resources/png/grass.png");
				grass = ImageIO.read(new File(url.getPath()));
				url = classLoader.getResource("resources/png/mountain.png");
				mountain = ImageIO.read(new File(url.getPath()));
				url = classLoader.getResource("resources/png/water.png");
				water = ImageIO.read(new File(url.getPath()));
				url = classLoader.getResource("resources/png/dim.png");
				dim = ImageIO.read(new File(url.getPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void visit(GrassTile grassTile) {
		drawTileAlgorithm(grass, grassTile.getMapObjects());
	}

	public void visit(MountainTile mountainTerrain) {
		drawTileAlgorithm(mountain, mountainTerrain.getMapObjects());
	}

	public void visit(WaterTile waterTile) {
		drawTileAlgorithm(water, waterTile.getMapObjects());
	}

	private void drawTileAlgorithm(Image img, Collection<MapObject> mapObjects) {
		scaleXandY(x, y);
		g.drawImage(img, drawx, drawy, 100, 100, null);
		drawMapObjects(mapObjects);
		// brightness 0 is full
		if (brightness > 0 && brightness <= 50) {
			g.drawImage(dim, drawx, drawy, 100, 100, null);
		} else if (brightness >= 100) {
			g.drawImage(dim, drawx, drawy, 100, 100, null);
			g.drawImage(dim, drawx, drawy, 100, 100, null);
			g.drawImage(dim, drawx, drawy, 100, 100, null);
		}
		drawDebug();
	}

	private void drawMapObjects(Collection<MapObject> mapObjects) {
		mapObjectRenderer.setX(x);
		mapObjectRenderer.setY(y);
		for (MapObject mapObject : mapObjects) {
			mapObject.accept(mapObjectRenderer);
		}
	}

	// TODO NOT WORKING
	/**
	 *
	 * Takes in a BufferedImage and a percentage and produces a new
	 * BufferedImage that is darker by that percentage amount.
	 *
	 * @param bufferedImage
	 *            - image to be copied and darkened.
	 * @param percentage
	 *            - percentage to darken that BufferedImage by. If this value
	 *            were 10 it would darken the image by 10%.
	 * @return The darkened image.
	 */
	public BufferedImage produceBufferedImageDarkenedByPercentage(
			BufferedImage bufferedImage, int percentage) {
		if (percentage < 0 || percentage > 100) {
			throw new IllegalArgumentException("Illegal percentage");
		}
		/**
		 * 100 corresponds to pitch black, 50 corresponds to 50% darkened, and 0
		 * corresponds to regular rendering. Do not go over 100 or under 0%
		 * brightness.
		 */
		int remainder = 100 - percentage;
		float remaining_light = (float) remainder / 100;
		RescaleOp op = new RescaleOp(remaining_light, 0, null);
		// If the destination image (second parameter of op.filter) is null, a
		// [new] BufferedImage will be created.
		BufferedImage darkened_image = op.filter(bufferedImage, null);
		return darkened_image;
	}

	private void drawDebug() {
		if (DEBUG) {
			g.setColor(Color.RED);
			g.drawRect(drawx, drawy, 100, 100);
			g.drawString("x: " + x + ",y: " + y, drawx, drawy);
		}
	}

	@Override
	public void setBrightness(int i) {
		brightness = i;
	}

}
