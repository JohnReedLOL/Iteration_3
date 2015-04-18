package model.effect.statseffect;

import model.entity.stats.Stats;

public class BurnMana extends StatsEffect{
	public BurnMana(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.burnMana(getMagnitude());
	}
}
