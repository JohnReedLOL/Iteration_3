package model.map;

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
    private DiscreteMap currentMap = null;

    private GameWorld() {
        //DEFAULTS ARE FINE
    }

    public static GameWorld getInstance() {
        if ( singleton == null ) {
            return new GameWorld();
        }
        else
            return singleton;
    }

    public static int incrementMaps() {
        //FOR USE IN MAP NAMING
        return numMaps++;
    }

    public DiscreteMap getCurrentMap() {
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
        return true;
    }

    public boolean setCurrentMap( String mapName ) {
        for ( DiscreteMap m : maps ) {
            if ( m.getName().equalsIgnoreCase( mapName ) ) {
                //DOES NOT VIOLATE TDA OR LOD: GETTING MAP (FRIEND) ATTRIBUTE
                //DOESN'T MODIFY MAP
                currentMap = m;
                return true;
            }
        }
        return false;
    }

    public boolean setCurrentMap( int index ) {
        if ( index < maps.size() ) {
            //kinda sh*tty looking but I think it's okay.
            currentMap = ( DiscreteMap )( (ArrayList) maps ).get( index );
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
}
