package model.entity.npc.mount;

import model.entity.Entity;

/**
 * Created by Troy on 4/19/2015.
 */
public class MountOwnership {

    private Entity owner;
    private Mount mount;

    public MountOwnership( Entity owner, Mount mount) {
        this.owner = owner;
        this.mount = mount;
    }

    public Mount getMount() {
        return mount;
    }

    public Entity getOwner() {
        return owner;
    }

    /**
     * NO SETTERS FOR OWNERSHIPS. MAKE A NEW ONE.
     */
}
