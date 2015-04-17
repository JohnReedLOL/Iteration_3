package model.prerequisite;

import model.entity.stats.SneakStatsVisitor;

public abstract class SneakStatsPrerequisite extends OccupationStatsPrerequisite implements SneakStatsVisitor{
	SneakStatsPrerequisite(int magnitude){
		super(magnitude);
	}
}
