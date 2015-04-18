package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetBargain extends StatsEffect{
	public SetBargain(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setBargain(getMagnitude());
	}
}
