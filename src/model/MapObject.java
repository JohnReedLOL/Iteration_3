package model;

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

    public abstract void createAssociation( Location location );
}
