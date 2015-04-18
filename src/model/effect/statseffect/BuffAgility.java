package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffAgility extends StatsEffect{
	public BuffAgility(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffAgility(getMagnitude());
	}
}
