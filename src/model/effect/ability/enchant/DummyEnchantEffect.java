package model.effect.ability.enchant;

import model.effect.Effect;
import model.entity.Entity;
import model.entity.behavior.movement.DummyMovement;

public class DummyEnchantEffect implements Effect {
    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void performEffect(Entity target) {
        target.setMovementBehavior(DummyMovement.getInstance());
    }
}
