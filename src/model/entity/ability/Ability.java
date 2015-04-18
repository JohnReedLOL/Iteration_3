package model.entity.ability;

import java.util.List;

import model.effect.Effect;
import model.entity.Entity;
import model.influence_set.InfluenceSet;
import model.prerequisite.Prerequisite;

public class Ability {
	List<InfluenceSet> affectedAreas;
	List<Effect> myEffects;
	List<Prerequisite> myLearnRequirements;
	List<Prerequisite> myUseRequirements;
	
	Ability(List<Effect> effects, List<Prerequisite> learnRequirements, List<Prerequisite> useRequirements, List<InfluenceSet> affectedAreas){
		myEffects = effects;
		myLearnRequirements = learnRequirements;
		myUseRequirements = useRequirements;
		this.affectedAreas = affectedAreas;
	}
	
	public boolean meetsLearnPrerequisites(Entity target){
		for(Prerequisite p : myLearnRequirements){
			if(!p.meetsRequirement(target)) {
				return false;
			};
		}
		return true;
	}
	
	public boolean meetsUsePrerequisites(Entity target){
		for(Prerequisite p : myUseRequirements){
			if(!p.meetsRequirement(target)) {
				return false;
			};
		}
		return true;
	}
	
	public void performEffect(Entity user){
		if(!meetsUsePrerequisites(user)) return;
		for(InfluenceSet i : affectedAreas){
			for(Effect e : myEffects){
				//TODO: tell the game map to apply the effect in the given influence set.
			}
		}
	}
}
