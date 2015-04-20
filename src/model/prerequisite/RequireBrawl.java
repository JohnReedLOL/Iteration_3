package model.prerequisite;

import model.entity.stats.SmasherStats;

public class RequireBrawl extends SmasherStatsPrerequisite{
	public RequireBrawl(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		if(stats.getBrawl() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
