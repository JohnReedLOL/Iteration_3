package model.effect.statseffect;

import model.entity.stats.Stats;

public abstract class OccupationStatsEffect extends StatsEffect{
	
	OccupationStatsEffect(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		/*
		 * Do nothing.
		 * NOTE: This is a defined behavior of the class
		 * because ANY Stats object IS a valid target
		 */
	}
}
