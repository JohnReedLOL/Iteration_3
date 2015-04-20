package model.prerequisite;

import model.entity.stats.Stats;

public class RequireMaxMana extends StatsPrerequisite{
	public RequireMaxMana(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getMaxMana() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
