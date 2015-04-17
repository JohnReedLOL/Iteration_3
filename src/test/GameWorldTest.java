package test;

import model.map.GameMap;
import model.map.GameWorld;

/**
 * Created by Troy on 4/17/2015.
 */
public class GameWorldTest {

    public static void main(String[] args) {
        GameWorld world = GameWorld.getInstance();

        for (int i = 0; i < 10; i++) {
            GameMap g = new GameMap();
            world.setCurrentMap( g );
            System.out.println("CREATING " +g.getName());
        }
        GameMap leMap = new GameMap();
        world.addMap( leMap );

        System.out.println("CURRENT MAP: " + world.getCurrentMap().getName());

        world.setCurrentMap(leMap);
        System.out.println("CURRENT MAP: " + world.getCurrentMap().getName());

        world.setCurrentMap("MAP_4");
        System.out.println("CURRENT MAP: " + world.getCurrentMap().getName());

        world.setCurrentMap( 7 );
        System.out.println("CURRENT MAP: " + world.getCurrentMap().getName());

        world.setCurrentMap( 15 );
        System.out.println("CURRENT MAP: " + world.getCurrentMap().getName());


    }
}
