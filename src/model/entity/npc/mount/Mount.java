package model.entity.npc.mount;

import model.MapObject;
import model.armory.Armory;
import model.entity.ClassicEntity;
import model.entity.Entity;
import model.entity.behavior.movement.MovementBehavior;
import model.entity.npc.NPC;
import model.entity.stats.StatsOwnership;
import model.inventory.Sack;
import model.map.coordinate.HexCoordinate;
import model.map.direction.Direction;
import view.utility.ObjectRenderer;

/**
 * Created by Troy on 4/19/2015.
 */
public class Mount extends NPC {
    private final int speedBonus = 5;

    public Mount(HexCoordinate coord) {
        super(coord);
    }

//    public Mount(String name, String description) {
//        super(name, description);
//    }
//
//    public Mount(Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
//        super(armory, sack, movement, stats);
//    }
//
//    public Mount(String name, String description, Armory armory, Sack sack, MovementBehavior movement, StatsOwnership stats) {
//        super(name, description, armory, sack, movement, stats);
//    }

    public void imposeMovementOn(Entity owner) {
        owner.setMovementBehavior(getMovementBehavior());
    }

    public void unimposeMovement() {

    }

    public int getSpeedBonus() {
        //YOU MAY OVERRIDE THIS TO CHANGE A MOUNT'S SPEED BONUS.
        return speedBonus;
    }

    @Override
    public boolean interact(MapObject obj) {
        ClassicEntity entity = (ClassicEntity) obj;

        if (entity.getIsMounted() && entity.getMountOwnership().getMount() != this) {
            return false;
        }

        entity.mount(this);
        return true;
    }

    @Override
    public void accept(ObjectRenderer mapObjectRenderer) {
        mapObjectRenderer.visit(this);
    }

    @Override
    public void move( Direction direction ) {
        super.move( direction );
        System.out.println("WEEEEEE VESPA");
    }

}
