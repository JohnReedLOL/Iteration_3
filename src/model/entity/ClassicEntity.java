package model.entity;

import model.MapObject;
import model.entity.npc.mount.Mount;
import model.entity.npc.mount.MountOwnership;
import model.entity.npc.pet.Pet;
import model.entity.npc.pet.PetOwnership;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class ClassicEntity extends Entity {

    /**
     * PROPERTIES
     */
    private MountOwnership mountOwnership = new MountOwnership(this, null);
    private PetOwnership petOwnership = new PetOwnership(this, null);
    private boolean isMounted = false;
    private ConversationTree conversationTree_;
    private ConversationNode lastThingSaidToMe_ = new ConversationNode("", "", "", "", "");
    private String lastThingISaid = "";

    /**
     * CONSTRUCTORS
     */
    public ClassicEntity(HexCoordinate location) {
        super(location);
        conversationTree_ = ConversationTreeFactory.makeVillagerConversationTree();
    }

    /**
     * GETTERS
     */
    public MountOwnership getMountOwnership() {
        return this.mountOwnership;
    }

    public PetOwnership getPetOwnership() {
        return this.petOwnership;
    }

    public boolean getIsMounted() {
        return this.isMounted;
    }

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
     * @return the conversationTree_
     */
    public ConversationTree getConversationTree_() {
        return conversationTree_;
    }

    /**
     * MUTATORS
     */
    public void setMountOwnership(MountOwnership ownership) {
        this.mountOwnership = ownership;
    }

    public void setPetOwnership(PetOwnership ownership) {
        this.petOwnership = ownership;
    }

    private void setIsMounted(boolean mounted) {
        this.isMounted = mounted;
    }

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
     * @param conversationTree_ the conversationTree_ to set
     */
    public void setConversationTree_(ConversationTree conversationTree_) {
        this.conversationTree_ = conversationTree_;
    }

    /**
     * IMPLEMENTATIONS
     */
    public void mount(Mount target) {
        setIsMounted(true);
        setMountOwnership(new MountOwnership(this, target));
        getMountOwnership().imposeMovementOn(this);
        System.out.println("YOU MOUNTED VESPA " + getStatsOwnership().getStats().getMovement());
        getStatsOwnership().getStats().buffMovement(getMountOwnership().getSpeedBonus());
        System.out.println("ENJOY YOUR VESPA " + getStatsOwnership().getStats().getMovement());
    }

    public void dismount() {
        setIsMounted(false);
        getMountOwnership().dismount();
    }

    public void givePet(Pet pet) {
        getPetOwnership().setPet(pet);
    }

    public void releasePet() {
        getPetOwnership().setPet(null);
    }

    @Override
    public void move(Direction direction) {
        boolean shouldMove = getMountOwnership().getMount() != null;
        super.move(direction);

        if ( shouldMove ) {
            getMountOwnership().getMount().move(direction);
            getMountOwnership().getMount().setDirection( direction );
        }


    }

    @Override
    public boolean createLocationAssociation(Location location) {
        return false;
    }

    @Override
    public boolean removeLocationAssociation(Location location) {
        return false;
    }

    @Override
    public void accept(ObjectRenderer mapObjectRenderer) {

    }

    @Override
    public boolean interact( MapObject entity ) {
        if ( entity == getMountOwnership().getMount() ) {
            return true;
        }
        return false;
    }
}
