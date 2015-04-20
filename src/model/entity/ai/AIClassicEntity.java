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
    private ConversationNode lastThingSaidToMe_ = new ConversationNode("", "", "", "", "");
    private String lastThingISaid = "";
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
    public ConversationNode getLastThingSaidToMe_() {
        return lastThingSaidToMe_;
    }

    /**
     * @return the lastThingISaid
     */
    public String getLastThingISaid() {
        return lastThingISaid;
    }

    /**
     * MUTATORS
     */
    /**
     * @param lastThingSaidToMe_ the lastThingSaidToMe_ to set
     */
    public void setLastThingSaidToMe_(ConversationNode lastThingSaidToMe_) {
        this.lastThingSaidToMe_ = lastThingSaidToMe_;
    }

    /**
     * @param lastThingISaid the lastThingISaid to set
     */
    public void setLastThingISaid(String lastThingISaid) {
        this.lastThingISaid = lastThingISaid;
    }

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
