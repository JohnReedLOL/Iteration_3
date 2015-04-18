package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffBargain extends StatsEffect{
	public BuffBargain(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffBargain(getMagnitude());
	}
}
