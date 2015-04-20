package model.entity.ai;

import model.MapObject;
import model.entity.ClassicEntity;
import model.entity.ConversationNode;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.influence_set.LinearInfluenceSet;
import model.map.GameWorld;
import model.map.coordinate.HexCoordinate;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class AIClassicEntity extends ClassicEntity {

    public void initiateConversationWithFacingEntity() {
        InfluenceSet lSet = new LinearInfluenceSet(this.getDirection(), 1, GameWorld.getCurrentMap().getLocationByMapObject(this));

    }

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
     * @return the lastThingSaidToMe_
     */
    /**
     * MUTATORS
     */
    /**
     * @param lastThingSaidToMe_ the lastThingSaidToMe_ to set
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

    /**
     * What is called by the game map when the interactor walks into you.
     * @param interactor
     * @return
     */
    @Override
    public boolean interact(MapObject interactor) {
        ClassicEntity partner = (ClassicEntity) interactor;
        return false;
    }
}
