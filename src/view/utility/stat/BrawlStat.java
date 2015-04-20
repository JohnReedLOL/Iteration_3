package view.utility.stat;

import model.entity.stats.SmasherStatsOwnership;
import model.entity.stats.StatsOwnership;


public class BrawlStat extends Stat {
	public BrawlStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SmasherStatsOwnership getOwner(){
		return (SmasherStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upBrawl();
	}
	
	public int getMag(){
		return getOwner().getStats().getBrawl();
	}
}
