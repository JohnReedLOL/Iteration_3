package model.map;

import model.entity.Entity;
import model.entity.memory.VisibleMap;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Troy on 4/17/2015.
 */
public class GameWorld {

    //A SINGLETON CLASS USED FOR GLOBAL ACCESS TO CURRENT MAP, AS WELL AS SETTING IT

    //this constant used for naming new maps.
    private static int numMaps = 0;

    private static GameWorld singleton = null;
    private Collection<DiscreteMap> maps = new ArrayList<DiscreteMap>();
    private static DiscreteMap currentMap = null;
    private static ArrayList<VisibleMap> visibleMaps = new ArrayList<VisibleMap>();

    private GameWorld() {
        //DEFAULTS ARE FINE
    }

    public static GameWorld getInstance() {
        if ( singleton == null ) {
            singleton = new GameWorld();
        }

        return singleton;
    }

    public static Entity getAvatar() {
        return getCurrentMap().getAvatar();
    }

    public static int incrementMaps() {
        //FOR USE IN MAP NAMING
        return numMaps++;
    }

    public static DiscreteMap getCurrentMap() {
        if (currentMap == null) {
            currentMap = new GameMap();
        }

        updateVisibleMap();
        return currentMap;
    }

    public boolean setCurrentMap( DiscreteMap map ) {
        //WILL ADD IF NOT THERE, AND THEN SET CURRENT
        if ( map == null ) {
            return false;
        }

        if ( !maps.contains( map ) ) {
            maps.add( map );
        }

        currentMap = map;
        updateVisibleMap();
        return true;
    }

    public boolean setCurrentMap( String mapName ) {
        for ( DiscreteMap m : maps ) {
            if ( m.getName().equalsIgnoreCase( mapName ) ) {
                //DOES NOT VIOLATE TDA OR LOD: GETTING MAP (FRIEND) ATTRIBUTE
                //DOESN'T MODIFY MAP
                currentMap = m;
                updateVisibleMap();
                return true;
            }
        }
        return false;
    }

    public boolean setCurrentMap( int index ) {
        if ( index < maps.size() ) {
            //kinda sh*tty looking but I think it's okay.
            currentMap = ( DiscreteMap )( (ArrayList) maps ).get( index );
            updateVisibleMap();
            return true;
        }
        return false;
    }

    public boolean addMap( DiscreteMap map ) {
        if ( !maps.contains( map ) ) {
            maps.add( map );
            return true;
        }
        else {
            return false;
        }
    }

    public static void updateVisibleMap() {
        for (VisibleMap v : visibleMaps ) {
            v.update();
        }
    }

    public void register( VisibleMap map ) {
        visibleMaps.add( map );
    }

    public void unregister( VisibleMap map ) {
        visibleMaps.remove( map );
    }
}
