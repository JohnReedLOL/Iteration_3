package model.entity.avatar;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.stats.StatsOwnership;
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

    public Avatar(String name, String description) {
        this(name, description, new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new StatsOwnership(null));
    }

    public Avatar(Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
        this("Avatar", "Avatar Desc", armory, sack, movement, stats);
    }

    public Avatar(String name, String description, Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
        super(name, description, armory, sack, movement, stats);
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
	
