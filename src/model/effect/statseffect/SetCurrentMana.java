package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetCurrentMana extends StatsEffect{
	public SetCurrentMana(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setCurrentMana(getMagnitude());
	}
}
