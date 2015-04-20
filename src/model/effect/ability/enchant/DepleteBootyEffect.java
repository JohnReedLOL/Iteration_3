package model.effect.ability.enchant;

import model.effect.Effect;
import model.entity.Entity;

public class DepleteBootyEffect implements Effect {
    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void performEffect(Entity target) {
        target.modifyBooty(Integer.MIN_VALUE);
    }
}
