package model.map.location;

import model.MapObject;
import model.entity.Entity;
import model.map.AreaEffect;
import model.map.TileMapObjectAssociation;
import model.map.decal.Decal;

import java.util.ArrayList;
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
        for (TileMapObjectAssociation t: mapObjects ) {
            if ( t.getMapObject().equals( m ) ) {   //we cannot add the same MapObject to more than one Tile.
                return false;
            }
        }

        TileMapObjectAssociation association = new TileMapObjectAssociation( this, m );
        mapObjects.add( association );

        return true;
    }

    @Override
    public boolean removeAssociation( MapObject m ) {
        for (TileMapObjectAssociation t: mapObjects ) {
            if ( t.getMapObject().equals( m ) ) {   //we cannot add the same MapObject to more than one Tile.
                mapObjects.remove( t );
                return true;
            }
        }

        return false;
    }

    @Override
    public Collection<MapObject> getMapObjects() {
        Collection<MapObject> objects = new ArrayList<MapObject>();
        for (TileMapObjectAssociation t: mapObjects ) {
            objects.add( t.getMapObject() );
        }

        return objects;
    }

    public boolean canPass( Entity e ) {
        //TODO
        //REASONABLE DEFAULT: UNLESS SUBCLASS PREVENTS IT, RETURN TRUE
        return true;
    }

    public void addDecal( Decal decal ) {
        this.decal = decal;
    }

    public void removeDecal() {
        decal = null;
    }
}
