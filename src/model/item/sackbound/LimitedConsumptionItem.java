package model.item.sackbound;

import model.entity.Entity;

public class LimitedConsumptionItem extends ConsumptionItem {
    /**
     * PROPERTIES
     */

    /**
     * CONSTRUCTORS
     */

    public LimitedConsumptionItem() {
        this("LimitedConsumptionItem", "LimitedConsumption Desc");
    }

    public LimitedConsumptionItem(String name, String description) {
        super(name, description);
    }

    /**
     * GETTERS
     */

    /**
     * MUTATORS
     */

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void apply(Entity owner) {
        if (meetsUseRequirements(owner)) {
            applyEffects(owner);
            owner.getInventoryOwnership().removeItem(this);
        }
    }
}
