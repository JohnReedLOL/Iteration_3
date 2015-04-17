package model.item;

import model.MapObject;
import model.entity.Entity;

public abstract class Item extends MapObject {
    public Item() {
        super("Item", "Item Desc");
    }

    public Item(String name, String description) {
        super(name, description);
    }

    public abstract boolean activateOnMap(Entity activator);
}
