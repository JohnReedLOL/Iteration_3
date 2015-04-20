package model.entity.npc.pet;

import model.entity.Entity;

/**
 * Created by Troy on 4/19/2015.
 */
public class PetOwnership {
    private Entity owner;
    private Pet pet;

    // Not sure what this is supposed to be used for, nor do I know if this
    // has some purpose to it.
//    private int relationLevel;

    public PetOwnership(Entity owner, Pet pet) {
        this.owner = owner;
        this.pet = pet;

        pet.setOwnership(this);
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
