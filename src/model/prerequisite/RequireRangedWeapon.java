package model.prerequisite;

import model.entity.stats.SneakStats;

public class RequireRangedWeapon extends SneakStatsPrerequisite{
	public RequireRangedWeapon(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		if(stats.getRangedWeapon() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
