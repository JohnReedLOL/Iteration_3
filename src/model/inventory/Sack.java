package model.inventory;

import model.item.sackbound.SackboundItem;

import java.util.ArrayList;

public class Sack {
    /**
     * PROPERTIES
     */

    private int size;
    private int capacity;
    private ArrayList<SackboundItem> items;

    public static final int DEFAULT_CAPACITY = 25;

    /**
     * CONSTRUCTORS
     */

    public Sack() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.items = new ArrayList<SackboundItem>();
    }

    public Sack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new ArrayList<SackboundItem>();
    }

    /**
     * GETTERS
     */

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<SackboundItem> getItems() {
        return this.items;
    }

    public SackboundItem getItem(SackboundItem item) {
        int index = this.items.indexOf(item);

        return getItem(index);
    }

    public SackboundItem getItem(int index) {
        return this.items.get(index);
    }

    /**
     * MUTATORS
     */

    public void setCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    public boolean addItem(SackboundItem item) {
        if (!isFull()) {
            this.items.add(item);
            incrementSize();

            return true;
        }

        return false;
    }

    public SackboundItem removeItem(SackboundItem item) {
        SackboundItem equipped = getItem(item);
        this.items.remove(item);
        decrementSize();

        return equipped;
    }

    /**
     * IMPLEMENTATIONS
     */

    private void incrementSize() {
        ++size;
    }

    private void decrementSize() {
        --size;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public boolean isFull() {
        return this.size == capacity;
    }
}
