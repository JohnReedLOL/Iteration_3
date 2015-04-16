package model.item.sackbound;

import model.entity.Entity;
import model.prerequisite.Prerequisite;

import java.util.ArrayList;

public abstract class ConsumptionItem extends SackboundItem {
    /**
     * PROPERTIES
     */

    private ArrayList<Prerequisite> usePrerequisites;

    /**
     * CONSTRUCTORS
     */

    public ConsumptionItem() {
        super();

        this.usePrerequisites = new ArrayList<Prerequisite>();
    }

    /**
     * GETTERS
     */

    public ArrayList<Prerequisite> getUsePrerequisites() {
        return this.usePrerequisites;
    }

    /**
     * MUTATORS
     */

    public void setUsePrerequisites(ArrayList<Prerequisite> prereqs) {
        this.usePrerequisites = prereqs;
    }

    public void addUsePrerequisite(Prerequisite prereq) {
        this.usePrerequisites.add(prereq);
    }

    public void removeUsePrerequisite(Prerequisite prereq) {
        this.usePrerequisites.remove(prereq);
    }

    /**
     * ABSTRACT METHODS
     */

    public abstract boolean activateOnMap(Entity activator);
    public abstract boolean use(Entity user);
}
