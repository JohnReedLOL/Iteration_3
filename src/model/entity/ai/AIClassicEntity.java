package model.entity.ai;

import model.entity.Entity;
import model.map.coordinate.HexCoordinate;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class AIClassicEntity extends Entity {
    /**
     * PROPERTIES
     */

    // TODO: Add DialogueTree


    /**
     * CONSTRUCTORS
     */

    public AIClassicEntity(HexCoordinate location) {
        super(location);
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
