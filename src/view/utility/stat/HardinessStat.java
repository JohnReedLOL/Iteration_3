package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class HardinessStat extends Stat {
	public HardinessStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upHardiness();
	}
	
	public int getMag(){
		return getOwner().getStats().getHardiness();
	}
}
