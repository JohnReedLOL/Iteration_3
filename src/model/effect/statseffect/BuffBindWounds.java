package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffBindWounds extends StatsEffect{
	public BuffBindWounds(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffBindWounds(getMagnitude());
	}
}
