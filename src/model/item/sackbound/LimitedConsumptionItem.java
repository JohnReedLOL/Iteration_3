package model.item.sackbound;

import model.entity.Entity;
import view.utility.ObjectRenderer;

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
    public LimitedConsumptionItem getDerivedClass() {
        return this;
    }

    @Override
    public void apply(Entity owner) {
        if (meetsUseRequirements(owner)) {
            applyEffects(owner);
            owner.getInventoryOwnership().removeItem(this);
        }
    }

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
