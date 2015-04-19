package model.effect;

import model.MapObject;
import model.entity.Entity;

public interface Effect {
    public void performEffect(Entity target);
    default void performEffect(MapObject obj) {}
}
