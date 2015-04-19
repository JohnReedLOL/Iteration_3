package test;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.stats.StatsOwnership;
import model.inventory.Sack;
import model.map.DiscreteMap;
import model.map.GameMap;
import model.map.coordinate.HexCoordinate;
import model.map.location.Location;
import model.map.location.Tile;

/**
 * Created by Troy on 4/18/2015.
 */
public class MapTest {

    public static void main(String[] args) {
        DiscreteMap map = new GameMap();

        HexCoordinate coord = new HexCoordinate(1, 7);
        //Entity entity = new Avatar("AVATAR", "TROY", new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new StatsOwnership(null));

        //map.insert( entity, map.getLocationByCoordinate(coord) );

        Tile tile = (Tile) map.getLocationByCoordinate( coord );

        coord = (HexCoordinate) map.getCoordinateByLocation( tile );

        int poop = 69;

    }
}
