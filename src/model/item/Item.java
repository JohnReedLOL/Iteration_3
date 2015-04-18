package model.item;

import model.MapObject;
import model.entity.Entity;
import model.map.location.Location;
import model.map.location.Tile;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Item extends MapObject {
    private Collection<ItemLocationAssociation> locationAssociations = new ArrayList<ItemLocationAssociation>();

    public Item() {
        super("Item", "Item Desc");
    }

    public Item(String name, String description) {
        super(name, description);
    }

    public Collection<ItemLocationAssociation> getLocationAssociations() {
        return this.locationAssociations;
    }

    @Override
    public void createAssociation( Location tile ) {
        for (ItemLocationAssociation ita : getLocationAssociations()) {
            if (ita.getLocation().equals(tile)) {
                return;
            }
        }

        getLocationAssociations().add(new ItemLocationAssociation(this, tile));
    }

    public abstract boolean activateOnMap(Entity activator);
}
