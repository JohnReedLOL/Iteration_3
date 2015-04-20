package model.entity.npc.pet;

import model.MapObject;
import model.entity.ClassicEntity;
import model.entity.Entity;
import model.entity.npc.NPC;
import model.map.coordinate.HexCoordinate;

/**
 * Created by Troy on 4/19/2015.
 */
public class Pet extends NPC {
    private PetOwnership petOwnership;

    public Pet(HexCoordinate coord) {
        super(coord);
    }

//    public Pet(String name, String description) {
//        super(name, description);
//    }
//
//    public Pet(String name, String description, Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
//        super(name, description, armory, sack, movement, stats);
//    }
//
//    public Pet(Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
//        super(armory, sack, movement, stats);
//    }

    public PetOwnership getOwnership() {
        return this.petOwnership;
    }

    public void setOwnership(PetOwnership ownership) {
        this.petOwnership = ownership;
    }

    public PetOwnership makeEntityAssociation( ClassicEntity entity ) {
        return new PetOwnership( entity, this );
    }

    @Override
    public boolean interact(MapObject obj) {
        ClassicEntity owner = (ClassicEntity) obj;
        if (owner.getPetOwnership().getOwner() == owner) {
            return false;
        }

        owner.setPetOwnership(new PetOwnership(owner, this));
        return false;
    }
}
