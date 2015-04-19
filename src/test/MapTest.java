package test;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.occupation.SneakOccupation;
import model.inventory.Sack;
import model.map.DiscreteMap;
import model.map.GameMap;
import model.map.coordinate.HexCoordinate;

/**
 * Created by Troy on 4/18/2015.
 */
public class MapTest {

    public static void main(String[] args) {

        DiscreteMap map = new GameMap();
        System.out.println(map.getName()+" " +map.getWidth());

        HexCoordinate coord = new HexCoordinate(1,1);
        Entity entity = new Avatar("AVATAR", "TROY", new Armory(), new Sack(), new SneakOccupation(), ClassicMovementBehavior.getInstance());

        //map.insert( entity, map.getLocationByCoordinate(coord) );




    }
}
