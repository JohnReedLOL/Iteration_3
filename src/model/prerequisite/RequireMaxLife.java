package model.prerequisite;

import model.entity.stats.Stats;

public class RequireMaxLife extends StatsPrerequisite{
	public RequireMaxLife(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		if(stats.getMaxLife() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
