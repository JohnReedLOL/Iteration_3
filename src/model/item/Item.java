package model.item;

import model.entity.Entity;

public interface Item {
    boolean activateOnMap(Entity activator);
}
