package model.item;

import model.MapObject;
import model.entity.Entity;


// TODO: Fix this to reflect that an Item is a MapObject.
public abstract class Item extends MapObject {
    public abstract boolean activateOnMap(Entity activator);
}
