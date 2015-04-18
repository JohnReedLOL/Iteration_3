package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class DebuffTwoHanded extends SmasherStatsEffect {
	public DebuffTwoHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.debuffTwoHanded(getMagnitude());
	}
}
