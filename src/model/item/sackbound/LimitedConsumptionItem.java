package model.item.sackbound;

import model.entity.Entity;

public class LimitedConsumptionItem extends ConsumptionItem {
    public LimitedConsumptionItem() {
        super();
    }

    @Override
    public boolean activateOnMap(Entity activator) {
        // placeholder.
        return false;
    }

    @Override
    public boolean use(Entity user) {
        // placeholder.
        return false;
    }
}
