package model.item.sackbound;

import model.entity.Entity;
import view.utility.ObjectRenderer;

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
    public UnlimitedConsumptionItem getDerivedClass() {
        return this;
    }

    @Override
    public void apply(Entity owner) {
        if (meetsUseRequirements(owner)) {
            applyEffects(owner);
        }
    }

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
