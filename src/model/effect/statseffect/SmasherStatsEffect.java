package model.effect.statseffect;

import model.entity.stats.SmasherStatsVisitor;

public abstract class SmasherStatsEffect extends OccupationStatsEffect implements SmasherStatsVisitor{
	SmasherStatsEffect(int magnitude){
		super(magnitude);
	}
}
