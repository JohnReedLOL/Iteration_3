/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outermost_Package.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Stats Pack for Drawable Things.
 *
 * @author John-Michael Reed
 */
public class ThingStatsPack implements Serializable {

    /* SHOULD ALL BE PRIVATE!!! */
    private int offensive_rating_;
    private int armor_rating_;

    /**
     * Sets the stats pack back to 0
     */
    public void reset() {
        armor_rating_ = 0;
        offensive_rating_ = 0;
    }

    public void setNew (ThingStatsPack newPack) {
        armor_rating_ = newPack.getArmor_rating_();
        offensive_rating_ = newPack.getOffensive_rating_();
    }

    public int getOffensive_rating_() {
        return offensive_rating_;
    }

    public int getArmor_rating_() {
        return armor_rating_;
    }

    protected void setOffensive_rating_(int i) {
        offensive_rating_ = i;
    }

    protected void setArmor_rating_(int i) {
        armor_rating_ = i;
    }

    public int incrementOffensive_rating_() {
        return ++offensive_rating_;
    }

    public int incrementtArmor_rating_() {
        return ++armor_rating_;
    }

    /**
     * Constructor: sets stats to 0.
     */
    public ThingStatsPack() {
        offensive_rating_ = 0;
        armor_rating_ = 0;
    }

    /**
     * Copy constructor substitute
     */
    public ThingStatsPack makeCopyOfMyself() {
        ThingStatsPack copy = new ThingStatsPack();
        copy.offensive_rating_ = this.offensive_rating_;
        copy.armor_rating_ = this.armor_rating_;
        return copy;
    }

    /**
     * Constructor: contains several parameters to set stats.
     *
     * @param o - offensive rating
     * @param a - armor rating
     */
    public ThingStatsPack(int o, int a) {
        offensive_rating_ = o;
        armor_rating_ = a;
    }

    /**
     * Adds on to the Drawable Thing stats pack.
     *
     * @param other
     */
    public void addOn(final ThingStatsPack other) {
        offensive_rating_ += other.offensive_rating_;
        armor_rating_ += other.armor_rating_;
    }

    /**
     * reduces Drawable Thing's stat pack.
     *
     * @param other
     */
    public void reduceBy(final ThingStatsPack other) {
        offensive_rating_ -= other.offensive_rating_;
        armor_rating_ -= other.armor_rating_;
    }

    @Override
    public String toString() {
        return "Offense: " + offensive_rating_
                + "Armor: " + armor_rating_;
    }

    public ArrayList<byte[]> makeByteArray() {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        arrayList.add(Integer.toString(offensive_rating_).getBytes());
        arrayList.add(Integer.toString(armor_rating_).getBytes());
        return arrayList;
    }
}
