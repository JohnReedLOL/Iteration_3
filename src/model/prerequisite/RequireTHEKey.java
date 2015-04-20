package model.prerequisite;

import model.entity.Entity;
import model.factories.ItemFactory;

public class RequireTHEKey implements Prerequisite {
    /**
     * IMPLEMENTATIONS
     */

    @Override
    public boolean meetsRequirement(Entity target) {
        return target.getInventoryOwnership().containsItem(ItemFactory.getTHEKey());
    }
}
