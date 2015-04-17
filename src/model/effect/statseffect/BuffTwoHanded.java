package model.effect.statseffect;

import model.entity.stats.SmasherStats;

public class BuffTwoHanded extends SmasherStatsEffect {
	public BuffTwoHanded(int magnitude){
		super(magnitude);
	}
	
	public void visit(SmasherStats stats){
		stats.buffTwoHanded(getMagnitude());
	}
}
