package model.map;


import model.map.coordinate.HexCoordinate;
import model.map.location.WaterTile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Troy on 4/16/2015.
 */
public class River {

    //private GameMap map;
    private List<WaterTile> waterTileList;
    private WaterTile head;
    private Collection<River> branches;
    private River parent;
    
    public River() {
        waterTileList = new ArrayList<WaterTile>();
    }

    public River( WaterTile source ) {
        waterTileList = new ArrayList<WaterTile>();
        branches = new ArrayList<River>();
        waterTileList.add( source );
        head = source;
    }

    public WaterTile getHead() {
        //I THINK THIS IS DUMB
        WaterTile w = null;
        if ((w = waterTileList.get( 0 )) != null)
            return w;
        return null;
    }

    public boolean addTileToRiver( WaterTile tile ) {
        if ( waterTileList.contains( tile ) )
            return false;

        waterTileList.add( tile );

        return true;
    }

    public void reverseDirection() {
        for( WaterTile t : waterTileList ) {
            t.reverseDirection( (HexCoordinate) GameWorld.getCurrentMap().getCoordinateByLocation( t ) );
        }

        for (River r: branches ) {
            r.reverseDirection();
        }
    }

    public void setFlow( int flow ) {
        for( WaterTile t : waterTileList ) {
            t.setFlowRate(flow);
        }

        for (River r: branches ) {
            r.setFlow(flow);
        }
    }

    public boolean addBranch( River river ) {
        //ensure no circular references
        if ( parent != river ) {
            branches.add(river);
            river.setParent( this );
        }

        return true;
    }

    public void setParent( River parent ) {
        this.parent = parent;
    }

    public List<WaterTile> getWaterTiles() {
        return waterTileList;
    }
}
