package model.item.sackbound;

import model.entity.Entity;
import view.utility.ObjectRenderer;

public class LimitedConsumptionItem extends ConsumptionItem {
    /**
     * PROPERTIES
     */

    private int numberOfConsumptions;

    /**
     * CONSTRUCTORS
     */

    public LimitedConsumptionItem() {
        this("LimitedConsumptionItem", "LimitedConsumption Desc", 1);
    }

    public LimitedConsumptionItem(String name, String description, int consumptions) {
        super(name, description);

        this.numberOfConsumptions = consumptions;
    }

    /**
     * GETTERS
     */

    public int getNumberOfConsumptions() {
        return this.numberOfConsumptions;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public LimitedConsumptionItem getDerivedClass() {
        return this;
    }

    @Override
    public void apply(Entity owner) {
        if (meetsUseRequirements(owner) && getNumberOfConsumptions() > 0) {
            applyEffects(owner);
            decrementConsumptions();

            if (getNumberOfConsumptions() < 1) {
                owner.getInventoryOwnership().removeItem(this);
            }
        }
    }

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}

    private void decrementConsumptions() {
        --numberOfConsumptions;
    }
}
