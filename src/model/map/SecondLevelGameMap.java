package model.map;

import model.map.builder.MapBuilder;
import model.map.builder.SecondLevelMapBuilder;

/**
 * Created by Troy on 4/19/2015.
 */
public class SecondLevelGameMap extends GameMap {

    @Override
    protected MapBuilder getMapBuilder() {
        return new SecondLevelMapBuilder();
    }
}
