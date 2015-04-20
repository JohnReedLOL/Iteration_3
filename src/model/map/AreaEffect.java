package model.map;

import java.util.ArrayList;
import java.util.List;

import model.effect.Effect;
import model.entity.Entity;
import java.util.ArrayList;

/**
 * Created by Troy on 4/16/2015.
 */
public class AreaEffect {	
	
    private List<Effect> effects;

    public AreaEffect(){
    	effects = new ArrayList<Effect>();
    }
    
    public void addEffect( Effect effect ) {
        effects.add( effect );
    }

    public boolean removeEffect( Effect effect ) {
        return effects.remove( effect );
    }

    public void performAllEffects(Entity entity){
    	for(Effect e : effects){
    		e.performEffect(entity);
    	}
    }
}
