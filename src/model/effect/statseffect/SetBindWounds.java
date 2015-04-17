package model.effect.statseffect;

import model.entity.stats.Stats;

public class SetBindWounds extends StatsEffect{
	public SetBindWounds(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.setBindWounds(getMagnitude());
	}
}
