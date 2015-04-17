package model.prerequisite;

import model.entity.stats.SummonerStatsVisitor;

public abstract class SummonerStatsPrerequisite extends OccupationStatsPrerequisite implements SummonerStatsVisitor{
	SummonerStatsPrerequisite(int magnitude){
		super(magnitude);
	}
}
