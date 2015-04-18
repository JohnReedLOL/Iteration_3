package model.inventory;

import model.item.sackbound.SackboundItem;

import java.util.ArrayList;

public class Sack {
    /**
     * PROPERTIES
     */

    private int size;
    private int capacity;
    private ArrayList<SackboundItem> contents;

    public static final int DEFAULT_CAPACITY = 25;

    /**
     * CONSTRUCTORS
     */

    public Sack() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.contents = new ArrayList<SackboundItem>();
    }

    public Sack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.contents = new ArrayList<SackboundItem>();
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

    public ArrayList<SackboundItem> getContents() {
        return this.contents;
    }

    public SackboundItem getItem(SackboundItem item) {
        int index = getContents().indexOf(item);

        return getItem(index);
    }

    public SackboundItem getItem(int index) {
        return getContents().get(index);
    }

    /**
     * MUTATORS
     */

    public void setCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    public boolean addItem(SackboundItem item) {
        if (!isFull()) {
            getContents().add(item);
            incrementSize();

            return true;
        }

        return false;
    }

    public SackboundItem removeItem(SackboundItem item) {
        SackboundItem equipped = getItem(item);
        getContents().remove(item);
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
        return getContents().isEmpty();
    }

    public boolean isFull() {
        return getSize() == capacity;
    }
}
