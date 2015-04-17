package model.item;

import model.entity.Entity;


// TODO: Fix this to reflect that an Item is a MapObject.
public abstract class Item {
    public abstract boolean activateOnMap(Entity activator);
}
