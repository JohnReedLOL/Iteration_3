package model.entity.npc;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.stats.StatsOwnership;
import model.inventory.Sack;
import model.map.coordinate.Coordinate2D;
import model.map.coordinate.HexCoordinate;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class NPC extends Entity {
    /**
     * PROPERTIES
     */

    /**
     * CONSTRUCTORS
     */

    public NPC(HexCoordinate coord) {
        super(coord);
    }

//    public NPC(String name, String description) {
//        this(name, description, new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new StatsOwnership(null));
//    }
//
//    public NPC(Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
//        this("NPC", "NPC Desc", armory, sack, movement, stats);
//    }
//
//    public NPC(String name, String description, Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
//        super(name, description, armory, sack, movement, stats);
//    }

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
