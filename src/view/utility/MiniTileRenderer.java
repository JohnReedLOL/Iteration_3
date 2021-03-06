package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.List;

import model.MapObject;
import model.map.location.BrickTile;
import model.map.location.GrassTile;
import model.map.location.MountainTile;
import model.map.location.WaterTile;

public class MiniTileRenderer extends MiniRenderer implements TileRenderer {

	private ObjectRenderer mapObjectRenderer;

	// FOR DEBUG
	private final boolean DEBUG = false;

	private int brightness;

	public MiniTileRenderer(Graphics g, int startx, int starty, List<MapObject> mapObjects) {
		//TODO how do we set AVATAR and Location
		super(g);
		this.startx = startx;
		this.starty = starty;
		mapObjectRenderer = new MiniGameObjectRenderer(g, startx, starty, mapObjects);
	}

	public MiniTileRenderer(Graphics g, List<MapObject> mapObjects) {
		super(g);
		this.startx = 0;
		this.starty = 0;
		mapObjectRenderer = new MiniGameObjectRenderer(g, mapObjects);
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
	public void visit(MountainTile mountainTile) {
		drawTileAlgorithm(Color.GRAY, mountainTile.getMapObjects());
	}

	@Override
	public void visit(BrickTile brickTile) {
		drawTileAlgorithm(Color.ORANGE, brickTile.getMapObjects());
	}

	private void drawTileAlgorithm(Color c, Collection<MapObject> mapObjects) {
		scaleXandY(x, y);
		g.setColor(c);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		g.setColor(Color.BLACK);
		g.drawRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawMapObjects(mapObjects);
		if (brightness > 0 && brightness < 100) {
			Color b = new Color(0,0,0,100);
			g.setColor(b);
			g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		} else if (brightness >=100) {
			Color b = new Color(0,0,0,200);
			g.setColor(b);
			g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
			
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
	

	public void setAvatarX(int x) {
		avatarx = x;
		mapObjectRenderer.setAvatarX(x);
	}

	public void setAvatarY(int y) {
		avatary = y;
		mapObjectRenderer.setAvatarY(y);
	}

}
