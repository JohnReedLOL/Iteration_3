package model.map;

import model.map.builder.MapBuilder;
import model.map.builder.SecondLevelMapBuilder;
import model.map.location.Location;
import utility.CoordUtil;

/**
 * Created by Troy on 4/19/2015.
 */
public class SecondLevelGameMap extends GameMap {

    @Override
    protected MapBuilder getMapBuilder() {
        return new SecondLevelMapBuilder();
    }

    @Override
    public Location getPreferredTeleportLocation() {
        return getLocationByCoordinate( CoordUtil.MAP_2_DEFAULT_COORDINATE );
    }
}
