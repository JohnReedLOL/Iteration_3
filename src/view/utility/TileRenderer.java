package view.utility;

import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.WaterTile;

public interface TileRenderer{
	
	public void visit(WaterTile waterTile);

	public void visit(GrassTile grassTile);

	public void visit(MountainTerrain mountainTile);

	public void setX(int x);

	public void setY(int y);

	public void setBrightness(int i);

}
