package model.entity.ability;

import java.util.ArrayList;
import java.util.List;

import model.entity.Entity;

public class AbilityLibrary {
	private List<Ability> learnedAbilities = new ArrayList<Ability>();
	private List<Ability> unlearnedAbilities = new ArrayList<Ability>();
	private Entity owner;
	
	public AbilityLibrary(Entity owner){
		this.owner = owner;
	}
	
	public void insertAbility(Ability ability){
		if(ability.meetsLearnPrerequisites(owner)){
			if(!learnedAbilities.contains(ability)) learnedAbilities.add(ability);
		}
		else{
			if(!unlearnedAbilities.contains(ability)) unlearnedAbilities.add(ability);
		}
	}
	
	public void removeAbility(Ability ability){
		if(ability.meetsLearnPrerequisites(owner)){
			if(learnedAbilities.contains(ability)) learnedAbilities.remove(ability);
		}
		else{
			if(unlearnedAbilities.contains(ability)) unlearnedAbilities.remove(ability);
		}
	}
	
	public boolean useAbility(int position){
		if(position < learnedAbilities.size() && learnedAbilities.get(position).meetsUsePrerequisites(owner)){
			learnedAbilities.get(position).performEffect(owner);
			return true;
		}
		return false;
		
	}
	
	public boolean useAbility(Ability ability){
		if(learnedAbilities.contains(ability)) return learnedAbilities.get(learnedAbilities.indexOf(ability)).performEffect(owner);
		return false;
	}
	
	public List<Ability> getLearnedAbilities(){
		return learnedAbilities;
	}
	
	public List<Ability> getUnlearnedAbilities(){
		return unlearnedAbilities;
	}
	
	public void notifyOfOwnerChanges(){
		for(Ability a : learnedAbilities){
			if(!a.meetsLearnPrerequisites(owner)){
				unlearnedAbilities.add(a);
				learnedAbilities.remove(a);
			}
		}
		for(Ability a : unlearnedAbilities){
			if(a.meetsLearnPrerequisites(owner)){
				learnedAbilities.add(a);
				unlearnedAbilities.remove(a);
			}
		}
	}
}
