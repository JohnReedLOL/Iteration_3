package view.utility;

import model.map.location.BrickTile;
import model.map.location.GrassTile;
import model.map.location.MountainTile;
import model.map.location.WaterTile;

public interface TileRenderer{
	
	public void visit(WaterTile waterTile);

	public void visit(GrassTile grassTile);

	public void visit(MountainTile mountainTile);

	public void visit(BrickTile brickTile);

	public void setX(int x);

	public void setY(int y);

	public void setStartX(int x);
	
	public void setStartY(int y);
	
	public void setBrightness(int i);

	public void setAvatarX(int avatarPosX);

	public void setAvatarY(int avatarPosY);

}
