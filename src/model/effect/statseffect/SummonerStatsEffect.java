package model.effect.statseffect;

import model.entity.stats.SummonerStatsVisitor;

public abstract class SummonerStatsEffect extends OccupationStatsEffect implements SummonerStatsVisitor{
	SummonerStatsEffect(int magnitude){
		super(magnitude);
	}
}
