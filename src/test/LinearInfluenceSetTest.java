package test;

import model.influence_set.AngularInfluenceSet;
import model.influence_set.InfluenceTile;
import model.influence_set.LinearInfluenceSet;
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
        GameMap game = new GameMap();
        AngularInfluenceSet lis = new AngularInfluenceSet(new SouthEastDirection(new HexCoordinate(0, 5)), 5, game.getLocationByCoordinate(new HexCoordinate(0, 5)));
        //lis.setUseSourceLocation( true );
        DiscreteMap map = GameWorld.getCurrentMap();

        Collection<InfluenceTile> set = lis.getInfluenceSet();
        for (InfluenceTile tile : set) {
            System.out.println("Radius: " + tile.getRadius());
            System.out.println("Tile: " + map.getCoordinateByLocation( tile.getTile() ) + "\n");
        }
    }
}
