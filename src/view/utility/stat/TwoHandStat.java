package view.utility.stat;

import model.entity.stats.SmasherStatsOwnership;
import model.entity.stats.StatsOwnership;


public class TwoHandStat extends Stat {
	public TwoHandStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SmasherStatsOwnership getOwner(){
		return (SmasherStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upTwoHanded();
	}
	
	public int getMag(){
		return getOwner().getStats().getTwoHanded();
	}
}
