package model.effect.movementeffects;

import application.Application;
import model.effect.Effect;
import model.entity.Entity;
import model.map.DiscreteMap;
import model.map.GameWorld;

public class TeleportEffect implements Effect {
    /**
     * PROPERTIES
     */

    private DiscreteMap toMap;

    /**
     * CONSTRUCTOR
     */

    public TeleportEffect(DiscreteMap map) {
        this.toMap = map;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void performEffect(Entity target) {
        Application.print("Teleport?");
        GameWorld.getCurrentMap().teleport(target, toMap);
        GameWorld.getInstance().setCurrentMap(toMap);
    }
}
