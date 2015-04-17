package model.map.location;

import model.MapObject;
import model.entity.Entity;
import model.map.AreaEffect;
import model.map.TileMapObjectAssociation;
import model.map.decal.Decal;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class Tile extends Location {


    private Collection<AreaEffect> areaEffects;
    private Collection<TileMapObjectAssociation> mapObjects;
    private Decal decal;

    @Override
    public boolean createAssociation( MapObject m ) {
        //TODO

        return false;
    }

    @Override
    public boolean removeAssociation( MapObject m ) {
        //TODO

        return false;
    }

    public boolean canPass( Entity e ) {
        //TODO

        return false;
    }

    public boolean addDecal( Decal decal ) {
        //TODO
        return false;
    }

    public void removeDecal() {
        decal = null;
    }
}
