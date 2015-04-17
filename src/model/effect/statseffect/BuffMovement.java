package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffMovement extends StatsEffect{
	public BuffMovement(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffMovement(getMagnitude());
	}
}
