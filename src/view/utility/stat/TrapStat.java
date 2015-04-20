package view.utility.stat;

import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.StatsOwnership;


public class TrapStat extends Stat {
	public TrapStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SneakStatsOwnership getOwner(){
		return (SneakStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upTrapping();
	}
	
	public int getMag(){
		return getOwner().getStats().getTrapping();
	}
}
