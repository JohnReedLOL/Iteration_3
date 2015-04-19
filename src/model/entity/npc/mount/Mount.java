package model.entity.npc.mount;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.npc.NPC;
import model.entity.stats.StatsOwnership;
import model.inventory.Sack;

/**
 * Created by Troy on 4/19/2015.
 */
public class Mount extends NPC {

    private int timeMounted;
    private final int speedBonus = 5;
    private MountOwnership ownership;

    public Mount(String name, String description) {
        super(name, description);
    }

    public Mount(Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
        super(armory, sack, movement, stats);
    }

    public Mount(String name, String description, Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
        super(name, description, armory, sack, movement, stats);
    }

    public void createMountOwnership( Entity entity ) {
        entity.getStatsOwnership().getStats().buffMovement(speedBonus);
        ownership = new MountOwnership( entity, this );
    }

    public void removeMountOwnership() {
        ownership.getOwner().getStatsOwnership().getStats().debuffMovement( speedBonus );
        ownership = null;
    }
}
