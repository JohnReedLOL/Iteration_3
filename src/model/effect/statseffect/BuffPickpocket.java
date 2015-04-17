package model.effect.statseffect;

import model.entity.stats.SneakStats;

public class BuffPickpocket extends SneakStatsEffect {
	public BuffPickpocket(int magnitude){
		super(magnitude);
	}
	
	public void visit(SneakStats stats){
		stats.buffPickpocket(getMagnitude());
	}
}
