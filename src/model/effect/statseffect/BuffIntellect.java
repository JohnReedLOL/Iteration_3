package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffIntellect extends StatsEffect{
	public BuffIntellect(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffIntellect(getMagnitude());
	}
}
