package view.utility;

import java.awt.Graphics;

import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public abstract class TileRenderer extends Renderer{
	
	public TileRenderer(Graphics g) {
		super(g);
	}
	
	public abstract void visit(WaterTile waterTile);

	public abstract void visit(GrassTile grassTile);

	public abstract void visit(MountainTerrain mountainTile);

}
