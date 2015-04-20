package model.effect.statseffect;

import model.effect.Effect;
import model.entity.Entity;

public class ModifyBooty implements Effect {
    private int delta;

    /**
     * CONSTRUCTOR
     */

    public ModifyBooty(int magnitude) {
        this.delta = magnitude;
    }

    /**
     * GETTER
     */

    public int getDelta() {
        return this.delta;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void performEffect(Entity target) {
        target.modifyBooty(getDelta());
    }
}
