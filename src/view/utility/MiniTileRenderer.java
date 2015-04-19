package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;

import model.MapObject;
import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public class MiniTileRenderer extends MiniRenderer implements TileRenderer{

	private ObjectRenderer mapObjectRenderer;

	// FOR DEBUG
	private final boolean DEBUG = true;
	
	public MiniTileRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
		mapObjectRenderer = new MiniGameObjectRenderer(g,startx, starty);
	}

	@Override
	public void visit(WaterTile waterTile) {
		scaleXandY(x, y);
		g.setColor(Color.BLUE);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawMapObjects(waterTile.getMapObjects());
		drawDebug();
	}

	@Override
	public void visit(GrassTile grassTile) {
		scaleXandY(x, y);
		g.setColor(Color.GREEN);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawMapObjects(grassTile.getMapObjects());
		drawDebug();
		
	}

	@Override
	public void visit(MountainTerrain mountainTile) {
		scaleXandY(x, y);
		g.setColor(Color.GRAY);
		g.fillRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
		drawMapObjects(mountainTile.getMapObjects());
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
			g.setColor(Color.BLACK);
			g.drawRect(drawx, drawy, SIZE_OF_MAP_PIXEL, SIZE_OF_MAP_PIXEL);
			//g.drawString("x: " + x + ",y: " + y, drawx, drawy);
		}
	}


}
