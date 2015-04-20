package model.entity;

import model.entity.npc.mount.Mount;
import model.entity.npc.mount.MountOwnership;
import model.entity.npc.pet.Pet;
import model.entity.npc.pet.PetOwnership;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import model.map.location.Location;
import view.utility.ObjectRenderer;

public class ClassicEntity extends Entity  {
    /**
     * PROPERTIES
     */

    private MountOwnership mountOwnership = new MountOwnership(this, null);
    private PetOwnership petOwnership = new PetOwnership(this, null);
    private boolean isMounted = false;
    private ConversationTree conversationTree_;
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

    /**
     * IMPLEMENTATIONS
     */

    public void mount(Mount target) {
        setIsMounted(true);
        getMountOwnership().imposeMovementOn(this);
        getStatsOwnership().getStats().buffMovement(getMountOwnership().getSpeedBonus());
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
        getMovementBehavior().move(this, direction);
        getMountOwnership().getMount().move(direction);
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

    /**
     * @return the conversationTree_
     */
    public ConversationTree getConversationTree_() {
        return conversationTree_;
    }

    /**
     * @param conversationTree_ the conversationTree_ to set
     */
    public void setConversationTree_(ConversationTree conversationTree_) {
        this.conversationTree_ = conversationTree_;
    }
}
