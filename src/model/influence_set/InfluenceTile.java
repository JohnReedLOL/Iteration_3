package model.influence_set;

import model.map.Tile;

/**
 * Created by Troy on 4/16/2015.
 */
public class InfluenceTile {

    private Tile tile;
    private int radius;

    public InfluenceTile( Tile tile ) {
        this.tile = tile;
        this.radius = 0;
    }

    public InfluenceTile( Tile tile, int radius ) {
        this.tile = tile;
        this.radius = radius;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
