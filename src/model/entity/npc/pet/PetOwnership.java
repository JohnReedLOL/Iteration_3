package model.entity.npc.pet;

import model.entity.Entity;

/**
 * Created by Troy on 4/19/2015.
 */
public class PetOwnership {
    private Entity owner;
    private Pet pet;

    public PetOwnership(Entity owner, Pet pet) {
        this.owner = owner;
        this.pet = pet;
    }

    public Entity getOwner() {
        return owner;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * NO SETTERS FOR AN OWNERSHIP CLASS. MAKE A NEW ONE.
     */
}
