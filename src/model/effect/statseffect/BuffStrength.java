package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffStrength extends StatsEffect{
	public BuffStrength(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffStrength(getMagnitude());
	}
}
