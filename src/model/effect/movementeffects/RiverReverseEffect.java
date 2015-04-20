package model.effect.movementeffects;

import model.effect.Effect;
import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.npc.mount.Mount;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.River;

import java.util.Collection;

/**
 * Created by Troy on 4/20/2015.
 */
public class RiverReverseEffect implements Effect {

    @Override
    public void performEffect(Entity target) {
        Collection<River> rivers = ((GameMap) GameWorld.getCurrentMap()).getRivers();
//        if ( target.getInventoryOwnership().getAllItems().size() > 0 ) {
        if ( GameWorld.getAvatar().equals( target ) ) {
            for (River r : rivers) {
                r.reverseDirection();
            }
        }
    }

    private boolean tryReverse( Avatar a ) {
        return true;
    }

    private boolean tryReverse( Mount m ) {
        return false;
    }
}
