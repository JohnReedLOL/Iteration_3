package model.map.location;

import view.utility.TileRenderer;
import model.entity.Entity;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;

/**
 * Created by Troy on 4/16/2015.
 */
public class WaterTile extends Tile {

    private int flowRate;
    private Direction direction;

    public boolean canPass( Entity entity ) {
        return false;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getFlowRate() {
        return flowRate;
    }

    public void setDirection( Direction direction ) {
        this.direction = direction;
    }

    public void setFlowRate(int flowRate) {
        this.flowRate = flowRate;
    }

    public void reverseDirection( HexCoordinate coordinate ) {
        this.direction = direction.getOppositeDirection( coordinate );
    }

	@Override
	public void accept(TileRenderer tileRendererVisitor) {
		tileRendererVisitor.visit(this);
	}
}
