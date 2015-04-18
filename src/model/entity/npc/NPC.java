package model.entity.npc;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.occupation.Occupation;
import model.inventory.Sack;
import model.map.location.Location;

public class NPC extends Entity {
    /**
     * PROPERTIES
     */

    /**
     * CONSTRUCTORS
     */

    public NPC(Armory armory, Sack sack, Occupation occupation) {
        this("NPC", "NPC Desc", armory, sack, occupation);
    }

    public NPC(String name, String description, Armory armory, Sack sack, Occupation occupation) {
        super(name, description, armory, sack, occupation);
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
