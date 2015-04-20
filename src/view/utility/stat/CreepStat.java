package view.utility.stat;

import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.StatsOwnership;


public class CreepStat extends Stat {
	public CreepStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SneakStatsOwnership getOwner(){
		return (SneakStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upCreep();
	}
	
	public int getMag(){
		return getOwner().getStats().getCreep();
	}
}
