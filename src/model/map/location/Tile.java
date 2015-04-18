package model.map.location;

import model.MapObject;
import model.entity.Entity;
import model.map.AreaEffect;
import model.map.TileMapObjectAssociation;
import model.map.decal.Decal;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class Tile extends Location {


    private Collection<AreaEffect> areaEffects = new ArrayList<AreaEffect>();
    private Collection<TileMapObjectAssociation> mapObjects = new ArrayList<TileMapObjectAssociation>();
    private Decal decal;

    public Tile() {

    }

    @Override
    public boolean createMapObjectAssociation(MapObject m) {
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
    public boolean removeMapObjectAssociation(MapObject m) {
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

    public void addAreaEffect( AreaEffect aoe ) {
        areaEffects.add( aoe );
    }

    public void removeAreaEffect( AreaEffect aoe ) {
        //NEEDS REFACTOR, PROBABLY WON'T REMOVE ANYTHING
        areaEffects.remove(aoe);
    }

    public boolean contains( MapObject mapObject ) {
        for ( TileMapObjectAssociation a: mapObjects ) {
            if( a.getMapObject().equals( mapObject ) ) {
                return true;
            }
        }
        return false;
    }
}
