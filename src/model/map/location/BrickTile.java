package model.map.location;

import view.utility.TileRenderer;
import model.entity.Entity;

/**
 * Created by Troy on 4/16/2015.
 */
public class BrickTile extends Tile {

    public boolean canPass( Entity entity ) {
        return true;
    }

    @Override
    public void accept(TileRenderer tileRendererVisitor) {
        tileRendererVisitor.visit( this );
    }
}
