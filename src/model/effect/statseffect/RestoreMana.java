package model.effect.statseffect;

import model.entity.stats.Stats;

public class RestoreMana extends StatsEffect{
	public RestoreMana(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.restoreMana(getMagnitude());
	}
}
