package model.map.builder;

import model.map.GameMap;

/**
 * Created by Troy on 4/17/2015.
 */
public class FirstLevelMapBuilder extends MapBuilder {


    @Override
    public GameMap generateMap() {
        return new GameMap();
    }
}
