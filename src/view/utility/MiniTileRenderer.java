package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;

import model.MapObject;
import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public class MiniTileRenderer extends MiniRenderer implements TileRenderer {

	private ObjectRenderer mapObjectRenderer;

	// FOR DEBUG
	private final boolean DEBUG = false;

	private int brightness;

	public MiniTileRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
		mapObjectRenderer = new MiniGameObjectRenderer(g, startx, starty);
	}

	public MiniTileRenderer(Graphics g) {
		super(g);
		this.startx = 0;
		this.starty = 0;
		mapObjectRenderer = new MiniGameObjectRenderer(g);
	}

	@Override
	public void visit(WaterTile waterTile) {
		drawTileAlgorithm(Color.BLUE, waterTile.getMapObjects());
	}

	@Override
	public void visit(GrassTile grassTile) {
		drawTileAlgorithm(Color.GREEN, grassTile.getMapObjects());
	}

	@Override
	public void visit(MountainTerrain mountainTile) {
		drawTileAlgorithm(Color.GRAY, mountainTile.getMapObjects());
	}

	private void drawTileAlgorithm(Color c, Collection<MapObject> mapObjects) {
		scaleXandY(x, y);
		g.setColor(c);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawMapObjects(mapObjects);
		g.setColor(Color.BLACK);
		g.drawRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
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
			g.drawRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
			// g.drawString("x: " + x + ",y: " + y, drawx, drawy);
		}
	}

	@Override
	public void setBrightness(int i) {
		brightness = i;
	}

}
