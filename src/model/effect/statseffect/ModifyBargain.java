package model.effect.statseffect;

import model.entity.stats.Stats;

public class ModifyBargain extends StatsEffect{
	public ModifyBargain(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.modifyBargain(getMagnitude());
	}
}
