package model.effect.statseffect;

import model.entity.stats.Stats;

public class BuffExperience extends StatsEffect{
	public BuffExperience(int magnitude){
		super(magnitude);
	}
	
	public void visit(Stats stats){
		stats.buffExperience(getMagnitude());
	}
}
