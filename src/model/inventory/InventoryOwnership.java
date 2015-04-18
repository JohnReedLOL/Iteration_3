package model.inventory;

import model.entity.Entity;
import model.item.sackbound.SackboundItem;
import model.map.location.Location;

import java.util.ArrayList;

public class InventoryOwnership {
    /**
     * PROPERTIES
     */

    private int permittedCapacity;
    private Entity owner;
    private Sack inventory;

    /**
     * CONSTRUCTORS
     */

    public InventoryOwnership(Entity entity) {
        this(entity, Sack.DEFAULT_CAPACITY);
    }

    public InventoryOwnership(Entity entity, Sack sack) {
        this.inventory = sack;
        this.permittedCapacity = Sack.DEFAULT_CAPACITY;
    }

    public InventoryOwnership(Entity entity, int capacity) {
        this.owner = entity;
        this.inventory = new Sack(capacity);
        this.permittedCapacity = capacity;
    }

    public InventoryOwnership(Entity entity, Sack sack, int capacity) {
        this.owner = entity;
        this.inventory = sack;
        this.permittedCapacity = capacity;
    }

    /**
     * GETTERS
     */

    public int getPermittedCapacity() {
        return this.permittedCapacity;
    }

    public int getSize() {
        return this.inventory.getSize();
    }

    public Entity getOwner() {
        return this.owner;
    }

    public Sack getOwnerInventory() {
        return this.inventory;
    }

    public SackboundItem getItem(int position) {
        return getOwnerInventory().getItem(position);
    }

    public SackboundItem takeItemFromInvetory(int position) {
        SackboundItem item = getItem(position);
        removeItem(item);

        return item;
    }

    public ArrayList<SackboundItem> getAllItems() {
        return getOwnerInventory().getContents();
    }

    /**
     * MUTATORS
     */

    public void setPermittedCapacity(int permittedCapacity) {
        this.permittedCapacity = permittedCapacity;
    }

    public void setInventoryCapacity(int inventoryCapacity) {
        getOwnerInventory().setCapacity(inventoryCapacity);
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public void setInventory(Sack inventory) {
        this.inventory = inventory;
    }

    public boolean addItem(SackboundItem item) {
        return getOwnerInventory().addItem(item);
    }

    public SackboundItem removeItem(SackboundItem item) {
        return getOwnerInventory().removeItem(item);
    }

    /**
     * IMPLEMENTATIONS
     */

    public boolean useItem(Location target, SackboundItem item) {
        // TODO: Implement once Location is filled out.

        return false;
    }
}
