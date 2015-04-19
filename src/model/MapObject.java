package model;

import model.effect.Effect;
import view.utility.GameObjectRenderer;
import view.utility.MiniGameObjectRenderer;
import view.utility.ObjectRenderer;
import model.map.location.Location;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class MapObject implements Derivable {
    private String name;
    private String description;

    public MapObject() {
        name = "";
        description = "";
    }

    public MapObject( String name, String description ) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    /**
     * IMPLEMENTATIONS
     */

    // Eric - Leaving for Troy todo.
    public abstract boolean createLocationAssociation(Location location);
    public abstract boolean removeLocationAssociation(Location location);

	public abstract void accept(ObjectRenderer mapObjectRenderer);
    public void accept(Effect effect) {
        effect.performEffect(this);
    }
}
