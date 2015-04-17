package model.prerequisite;

import model.entity.stats.Stats;

public abstract class OccupationStatsPrerequisite extends StatsPrerequisite{
		public OccupationStatsPrerequisite(int magnitude){
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
