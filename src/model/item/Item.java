package model.item;

import model.MapObject;
import model.entity.Entity;
import model.map.location.Location;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Item extends MapObject {
    /**
     * PROPERTIES
     */

    private Collection<ItemLocationAssociation> locationAssociations = new ArrayList<ItemLocationAssociation>();

    /**
     * CONSTRUCTORS
     */

    public Item() {
        super("Item", "Item Desc");
    }

    public Item(String name, String description) {
        super(name, description);
    }

    /**
     * GETTERS
     */

    public Collection<ItemLocationAssociation> getLocationAssociations() {
        return this.locationAssociations;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public boolean createLocationAssociation(Location tile) {
        for (ItemLocationAssociation ita : getLocationAssociations()) {
            if (ita.getLocation().equals(tile)) {
                return false;
            }
        }

        getLocationAssociations().add(new ItemLocationAssociation(this, tile));
        return true;
    }

    @Override
    public boolean removeLocationAssociation(Location tile) {
        for (ItemLocationAssociation ita : getLocationAssociations()) {
            if (ita.getLocation().equals(tile)) {
                getLocationAssociations().remove(ita);
                return true;
            }
        }

        return false;
    }

    @Override
    public Item getDerivedClass() {
        return this;
    }

    public abstract boolean activateOnMap(Entity activator);
    public abstract void apply(Entity owner);

    @Override
    public boolean interact( MapObject interactor ) {


        return activateOnMap( (Entity) interactor );
    }

    @Override
    public String talk() {
        return "Item: The item says nothing... what did you expect?";
    }

}
