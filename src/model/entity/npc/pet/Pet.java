package model.entity.npc.pet;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.npc.NPC;
import model.entity.stats.StatsOwnership;
import model.inventory.Sack;

/**
 * Created by Troy on 4/19/2015.
 */
public class Pet extends NPC {

    private int timeOwned;
    private int relationLevel;

    public Pet(String name, String description) {
        super(name, description);
    }

    public Pet(String name, String description, Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
        super(name, description, armory, sack, movement, stats);
    }

    public Pet(Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
        super(armory, sack, movement, stats);
    }

    public PetOwnership makeEntityAssociation( Entity entity ) {
        return new PetOwnership( entity, this );
    }
}
