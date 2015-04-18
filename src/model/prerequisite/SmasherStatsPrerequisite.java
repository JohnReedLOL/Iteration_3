package model.prerequisite;

import model.entity.stats.SmasherStatsVisitor;

public abstract class SmasherStatsPrerequisite extends OccupationStatsPrerequisite implements SmasherStatsVisitor{
	SmasherStatsPrerequisite(int magnitude){
		super(magnitude);
	}
}
