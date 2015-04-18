package model.item;

import model.MapObject;

public class ItemLocationAssociation {
    /**
     * PROPERTIES
     */

    private MapObject mapObject;
    private Item item;

    /**
     * CONSTRUCTORS
     */

    public ItemLocationAssociation(Item item, MapObject mapObject) {
        this.mapObject = mapObject;
        this.item = item;
    }

    /**
     * GETTERS
     */

    public MapObject getMapObject() {
        return this.mapObject;
    }

    public Item getItem() {
        return this.item;
    }
}
