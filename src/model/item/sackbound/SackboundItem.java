package model.item.sackbound;

import model.effect.Effect;
import model.entity.Entity;
import model.item.Item;
import model.map.GameMap;
import model.map.GameWorld;
import model.prerequisite.Prerequisite;
import view.utility.ObjectRenderer;

import java.util.ArrayList;

public class SackboundItem extends Item {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> pickUpPrerequisites = null;
    private ArrayList<Effect> pickUpEffects = null;

    /**
     * CONSTRUCTORS
     */

    public SackboundItem() {
        this("SackboundItem", "Sackbound Desc");
    }

    public SackboundItem(String name, String description) {
        super(name, description);

        this.pickUpPrerequisites = new ArrayList<Prerequisite>();
        this.pickUpEffects = new ArrayList<Effect>();
    }

    @Override
    public void accept(ObjectRenderer mapObjectRenderer) {
        mapObjectRenderer.visit(this);
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getPickUpPrerequisites() {
        return this.pickUpPrerequisites;
    }

    public ArrayList<Effect> getPickUpEffects() {
        return this.pickUpEffects;
    }

    /**
     * MUTATORS
     */

    public void addPickUpPrerequisite(Prerequisite prereq) {
        getPickUpPrerequisites().add(prereq);
    }

    public void removePickUpPrerequisite(Prerequisite prereq) {
        getPickUpPrerequisites().remove(prereq);
    }

    public void addPickUpEffect(Effect effect) {
        getPickUpEffects().add(effect);
    }

    public void removePickUpEffect(Effect effect) {
        getPickUpEffects().remove(effect);
    }

    /**]
     * IMPLEMENTATIONS
     */

    @Override
    public SackboundItem getDerivedClass() {
        return this;
    }

    @Override
    public boolean activateOnMap(Entity activator) {
        if (!meetsPickUpRequirements(activator)) {
            return false;
        }
        boolean value =  activator.getInventoryOwnership().addItem(this);
        if ( value ) {
            GameWorld.getCurrentMap().remove( this );
            System.out.println(" YA DONE PICKED UP AN TIEM!!");
        }
        return value;
    }

    @Override
    public void apply(Entity owner) {
        owner.getInventoryOwnership().addItem(this);
    }

    protected boolean meetsPickUpRequirements(Entity target) {
        for (Prerequisite req : getPickUpPrerequisites()) {
            if (!req.meetsRequirement(target)) {
                return false;
            }
        }

        return true;
    }
}
