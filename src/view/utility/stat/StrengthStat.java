package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class StrengthStat extends Stat {
	public StrengthStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upStrength();
	}
	
	public int getMag(){
		return getOwner().getStats().getStrength();
	}
}
