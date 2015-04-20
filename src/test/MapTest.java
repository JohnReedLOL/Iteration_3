package test;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.npc.pet.Pet;
import model.entity.stats.StatsOwnership;
import model.inventory.Sack;
import model.map.DiscreteMap;
import model.map.GameMap;
import model.map.SecondLevelGameMap;
import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.location.Location;
import model.map.location.Tile;

/**
 * Created by Troy on 4/18/2015.
 */
public class MapTest {

    public static void main(String[] args) {
        DiscreteMap map = new GameMap();
        map.populate();

        DiscreteMap otherMap = new SecondLevelGameMap();
        otherMap.populate();

        HexCoordinate coord = new HexCoordinate(1, 7);
        Entity entity = new Avatar( coord );

        //map.insert( entity, map.getLocationByCoordinate(coord) );

        map.insert(entity, map.getLocationByCoordinate(coord));

        System.out.println(map.getLocationByMapObject(entity));

        System.out.println(map.getLocationByCoordinate(new HexCoordinate(1, 7)).getMapObjects().contains(entity));

        map.move(entity, map.getCoordinateByLocation(map.getLocationByMapObject(entity)), new HexCoordinate(5, 5));

        System.out.println(map.getLocationByCoordinate(new HexCoordinate(5, 5)).getMapObjects().contains(entity));

        map.teleport(entity, otherMap);
        otherMap.move(entity, otherMap.getCoordinateByLocation(otherMap.getLocationByMapObject(entity)), new HexCoordinate(5, 6));

        System.out.println(" FIRST MAP : " +map.getLocationByCoordinate(new HexCoordinate(5, 6)).getMapObjects().contains(entity));
        System.out.println( "SECOND MAP : " +otherMap.getLocationByCoordinate(new HexCoordinate(5, 5)).getMapObjects().contains(entity) );

        int poop = 69;

    }
}
