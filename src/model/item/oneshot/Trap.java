package model.item.oneshot;

import java.util.ArrayList;
import java.util.List;

import model.MapObject;
import model.entity.Entity;
import model.map.GameWorld;
import model.prerequisite.Prerequisite;

public class Trap extends OneShotItem {
	List<Prerequisite> visionPrereqs;
	List<Prerequisite> disarmPrereqs;
	
	public Trap(){
		visionPrereqs = new ArrayList<Prerequisite>();
		disarmPrereqs = new ArrayList<Prerequisite>();
	}
	
	public boolean interact(MapObject m){
		Entity incoming = (Entity) m;
		for(Prerequisite p : disarmPrereqs){
			if(!p.meetsRequirement(incoming)){
				applyActivationEffects(incoming);
				break;
			}
		}
		GameWorld.getCurrentMap().remove(this);
		return true;
	}
	
	public boolean canSee(Entity e){
		for(Prerequisite p : visionPrereqs){
			if(!p.meetsRequirement(e)) return false;
		}
		return true;
	}
	
	public void addVisionPrerequisite(Prerequisite p){
		visionPrereqs.add(p);
	}
	
	public void addDisarmPrerequisite(Prerequisite p){
		disarmPrereqs.add(p);
	}

}
