package model.entity.ability;

import java.util.List;

import model.effect.Effect;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.map.GameWorld;
import model.prerequisite.Prerequisite;

public class Ability {
	List<InfluenceSet> affectedAreas;
	List<Effect> myEffects;
	List<Effect> costOfEffects;
	List<Prerequisite> myLearnRequirements;
	List<Prerequisite> myUseRequirements;
	String name;
	
	public Ability(List<Effect> effects, List<Prerequisite> learnRequirements, List<Prerequisite> useRequirements, List<InfluenceSet> affectedAreas,
				   List<Effect> costs, String name){
		this.myEffects = effects;
		this.myLearnRequirements = learnRequirements;
		this.myUseRequirements = useRequirements;
		this.affectedAreas = affectedAreas;
		this.costOfEffects = costs;
		this.name = name;
	}
	
	public boolean meetsLearnPrerequisites(Entity target){
		for(Prerequisite p : myLearnRequirements){
			if(!p.meetsRequirement(target)) {
				return false;
			}
		}
		return true;
	}
	
	public void setName(String nam){
		name = nam;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean meetsUsePrerequisites(Entity target){
		for(Prerequisite p : myUseRequirements){
			if(!p.meetsRequirement(target)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean performEffect(Entity user){
		if(!meetsUsePrerequisites(user)) return false;
		for(InfluenceSet i : affectedAreas){
			i.setSourceLocation(GameWorld.getCurrentMap().getLocationByCoordinate(GameWorld.getCurrentMap().getMapObjectCoordinate(user)));
			for(Effect e : myEffects){
				GameWorld.getCurrentMap().performEffect(e, i);
			}
		}
		for (Effect e : costOfEffects) {
			e.performEffect(user);
		}

		return true;
	}
}
