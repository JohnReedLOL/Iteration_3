package model.entity.npc;

import model.armory.Armory;
import model.entity.Entity;
import model.inventory.Sack;
import model.map.location.Location;

public class NPC extends Entity {
    /**
     * PROPERTIES
     */

    /**
     * CONSTRUCTORS
     */

    public NPC(Armory armory, Sack sack) {
        super(armory, sack);
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
    public boolean createLocationAssociation(Location location) {
        // TODO
        return false;
    }

    @Override
    public boolean removeLocationAssociation(Location location) {
        // TODO
        return false;
    }
}
