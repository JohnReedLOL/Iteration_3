package model.item.sackbound;

import model.entity.Entity;

public class UnlimitedConsumptionItem extends ConsumptionItem {
    public UnlimitedConsumptionItem() {
        this("UnlimitedConsumptionItem", "UnlimitedConsumption Desc");
    }

    public UnlimitedConsumptionItem(String name, String description) {
        super(name, description);
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void apply(Entity owner) {
        if (meetsUseRequirements(owner)) {
            applyEffects(owner);
        }
    }
}
