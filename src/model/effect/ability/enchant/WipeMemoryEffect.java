package model.effect.ability.enchant;

import model.effect.Effect;
import model.entity.Entity;

public class WipeMemoryEffect implements Effect {
    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void performEffect(Entity target) {
        target.wipeMemory();
    }
}
