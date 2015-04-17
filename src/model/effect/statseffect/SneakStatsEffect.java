package model.effect.statseffect;

import model.entity.stats.SneakStatsVisitor;

public abstract class SneakStatsEffect extends OccupationStatsEffect implements SneakStatsVisitor{
	SneakStatsEffect(int magnitude){
		super(magnitude);
	}
}
