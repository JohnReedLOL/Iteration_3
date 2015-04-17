package model.map.builder;

import model.map.DiscreteMap;
import model.map.GameMap;

/**
 * Created by Troy on 4/17/2015.
 */
public abstract class MapBuilder {
    //This is NOT the GoF Builder Pattern. It is a mechanism of generating structured maps.
    //May replace with using configuration file if needed.

    public abstract DiscreteMap generateMap();
}
