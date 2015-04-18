package model.item;

import model.map.location.Location;

public class ItemLocationAssociation {
    /**
     * PROPERTIES
     */

    private Location location;
    private Item item;

    /**
     * CONSTRUCTORS
     */

    public ItemLocationAssociation(Item item, Location location) {
        this.location = location;
        this.item = item;
    }

    /**
     * GETTERS
     */

    public Location getLocation() {
        return this.location;
    }

    public Item getItem() {
        return this.item;
    }
}
