package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyCurrentMana extends StatsEffect{
	public ModifyCurrentMana(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyCurrentMana(getMagnitude());
	}
}
