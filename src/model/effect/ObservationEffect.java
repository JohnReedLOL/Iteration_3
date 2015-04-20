package model.effect;

import model.ModelViewBundle;
import model.entity.Entity;

public class ObservationEffect implements Effect {
    /**
     * PROPERTIES
     */

    private int accuracy;

    /**
     * CONSTRUCTORS
     */

    public ObservationEffect(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * GETTERS
     */

    private int getAccuracy() {
        return this.accuracy;
    }

    /**
     * MUTATORS
     */

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * IMPLEMENTATIONS
     */

    @Override
    public void performEffect(Entity target) {
        StringBuilder builder = new StringBuilder();
        int obscureLevel = obscure(target.getStatsOwnership().getLevel());
        int obscureHealth = obscure(target.getStatsOwnership().getCurrentLife());
        int obscureMana = obscure(target.getStatsOwnership().getCurrentMana());

        builder.append("Level: " + obscureLevel  + "\n");
        builder.append("Life: "  + obscureHealth + "\n");
        builder.append("Mana: "  + obscureMana);

        ModelViewBundle.getInstance().setCurrentKnownInfo(builder.toString());
    }

    private int obscure(int value) {
        double level = f(value);
        double curacy = f(getAccuracy());

        return (int)(curacy / level);
    }

    private double f(int val) {
        return ((0.0008 * (val * val)) + (4  * val) + (40));
    }
}
