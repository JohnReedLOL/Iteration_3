package model.effect;

import model.entity.Entity;

public interface Effect {
    boolean affect(Entity target);
}
