package test;

import model.influence_set.AngularInfluenceSet;
import model.influence_set.InfluenceTile;
import model.influence_set.LinearInfluenceSet;
import model.influence_set.RadialInfluenceSet;
import model.map.DiscreteMap;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.coordinate.HexCoordinate;
import model.map.direction.NorthEastDirection;
import model.map.direction.SouthDirection;
import model.map.direction.SouthEastDirection;

import java.util.Collection;

public class LinearInfluenceSetTest {
    public static void main(String[] args) {

        GameWorld world = GameWorld.getInstance();
//        GameMap game = new GameMap();
        DiscreteMap map = GameWorld.getCurrentMap();
        AngularInfluenceSet lis = new AngularInfluenceSet( new SouthEastDirection( new HexCoordinate(0,2)), 4, map.getLocationByCoordinate(new HexCoordinate(0, 2)));
        lis.setUseSourceLocation( true );
        //lis.setUseSourceLocation( true );

        Collection<InfluenceTile> set = lis.getInfluenceSet();
        for (InfluenceTile tile : set) {
            System.out.println("Radius: " + tile.getRadius());
            System.out.println("Tile: " + map.getCoordinateByLocation( tile.getTile() ).getX() + ", " +map.getCoordinateByLocation( tile.getTile() ).getY() + "\n");
        }
    }
}
