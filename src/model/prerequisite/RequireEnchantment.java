package model.prerequisite;

import model.entity.stats.SummonerStats;

public class RequireEnchantment extends SummonerStatsPrerequisite{
	public RequireEnchantment(int magnitude){
		super(magnitude);
	}
	
	public void visit(SummonerStats stats){
		if(stats.getEnchantment() >= getMagnitude()) {setPassed(true);}
		else {setPassed(false);}
	}
}
