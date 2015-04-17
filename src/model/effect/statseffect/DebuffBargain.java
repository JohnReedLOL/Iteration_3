package model.effect.statseffect;

import model.entity.stats.Stats;

public class DebuffBargain extends StatsEffect{
	public DebuffBargain(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.debuffBargain(getMagnitude());
	}
}
