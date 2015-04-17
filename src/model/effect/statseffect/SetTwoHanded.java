package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class SetTwoHanded extends SmasherStatsEffect {
	public SetTwoHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.setTwoHanded(getMagnitude());
	}
}
