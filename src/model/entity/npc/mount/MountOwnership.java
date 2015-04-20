package model.entity.npc.mount;

import model.entity.ClassicEntity;
import model.entity.Entity;
import model.entity.behavior.movement.MovementBehavior;

/**
 * Created by Troy on 4/19/2015.
 */
public class MountOwnership {
    private ClassicEntity owner;
    private Mount mount;
    private MovementBehavior ownerPreviousBehavior;

    public MountOwnership( ClassicEntity owner, Mount mount) {
        this.owner = owner;
        this.mount = mount;
        this.ownerPreviousBehavior = owner.getMovementBehavior();
    }

    public Mount getMount() {
        return mount;
    }

    public Entity getOwner() {
        return owner;
    }

    public int getSpeedBonus() {
        return getMount().getSpeedBonus();
    }

    public MovementBehavior getOwnerPreviousBehavior() {
        return this.ownerPreviousBehavior;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
    }

    private void setOwnerPreviousBehavior(MovementBehavior behavior) {
        this.ownerPreviousBehavior = behavior;
    }

    public void imposeMovementOn(Entity owner) {
        getMount().imposeMovementOn(owner);
        getOwner().getStatsOwnership().getStats().buffMovement(getSpeedBonus());
    }

    public void dismount() {
        getMount().unimposeMovement();
        getOwner().getStatsOwnership().getStats().debuffMovement(getSpeedBonus());
        getOwner().setMovementBehavior(getOwnerPreviousBehavior());
        setMount(null);
    }

    /**
     * NO SETTERS FOR OWNERSHIPS. MAKE A NEW ONE.
     */
}
