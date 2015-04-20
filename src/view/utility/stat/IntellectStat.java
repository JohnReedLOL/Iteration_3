package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class IntellectStat extends Stat {
	public IntellectStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upIntellect();
	}
	
	public int getMag(){
		return getOwner().getStats().getIntellect();
	}
}
