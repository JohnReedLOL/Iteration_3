package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class ModifyTwoHanded extends SmasherStatsEffect {
	public ModifyTwoHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.modifyTwoHanded(getMagnitude());
	}
}
