package model.map;

import model.effect.Effect;
import model.entity.Entity;

import java.util.List;

/**
 * Created by Troy on 4/16/2015.
 */
public abstract class AreaEffect {

    private List<Effect> effects;

    public void addEffect( Effect effect ) {
        effects.add( effect );
    }

    public boolean removeEffect( Effect effect ) {
        return effects.remove( effect );
    }

    public abstract void performAllEffects(Entity entity);
}
