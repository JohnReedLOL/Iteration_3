package model.map;

import model.MapObject;
import model.map.direction.Direction;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.Collection;

/**
 * Created by Troy on 4/16/2015.
 */
public class GameMap extends DiscreteMap {


    public GameMap() {

    }

    @Override
    public void insert( MapObject m, Location l ) {

    }

    @Override
    public void remove( MapObject m ) {

    }

    @Override
    public void relocate( MapObject m, Location l ) {

    }

    @Override
    public void move( MapObject m, Direction l ) {

    }

    @Override
    public Tile getLocationFromDirection(Location l, Direction d) {
        return null;
    }

//    @Override
//    public void insert(MapObject m, Tile l) {
//
//    }
//
//    @Override
//    public void remove(MapObject m) {
//
//    }
//
//    @Override
//    public void move(MapObject m, Tile l) {
//
//    }
//
//    @Override
//    public void move(MapObject m, Direction l) {
//
//    }
}
