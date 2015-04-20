package view.utility.stat;

import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.StatsOwnership;


public class PickpocketStat extends Stat {
	public PickpocketStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SneakStatsOwnership getOwner(){
		return (SneakStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upPickpocket();
	}
	
	public int getMag(){
		return getOwner().getStats().getPickpocket();
	}
}
