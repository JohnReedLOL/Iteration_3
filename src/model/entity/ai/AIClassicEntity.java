package model.entity.ai;

import model.entity.ClassicEntity;
import model.entity.ConversationNode;
import model.map.coordinate.HexCoordinate;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class AIClassicEntity extends ClassicEntity {
    /**
     * PROPERTIES
     */
    private ConversationNode lastThingSaidToMe_ = new ConversationNode("","","","","");
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

    /**
     * @return the lastThingSaidToMe_
     */
    public ConversationNode getLastThingSaidToMe_() {
        return lastThingSaidToMe_;
    }

    /**
     * @param lastThingSaidToMe_ the lastThingSaidToMe_ to set
     */
    public void setLastThingSaidToMe_(ConversationNode lastThingSaidToMe_) {
        this.lastThingSaidToMe_ = lastThingSaidToMe_;
    }
}
