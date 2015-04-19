package model.entity.avatar;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.behavior.movement.MovementBehavior;
import model.inventory.Sack;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class Avatar extends Entity {
    /**
     * PROPERTIES
     */

    /**
     * CONSTRUCTORS
     */

    public Avatar(Armory armory, Sack sack, MovementBehavior movement) {
        this("Avatar", "Avatar Desc", armory, sack, movement);
    }

    public Avatar(String name, String description, Armory armory, Sack sack, MovementBehavior movement) {
        super(name, description, armory, sack, movement);
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

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
	
