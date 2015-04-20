package view.utility.stat;

import model.entity.stats.SmasherStatsOwnership;
import model.entity.stats.StatsOwnership;


public class OneHandStat extends Stat {
	public OneHandStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SmasherStatsOwnership getOwner(){
		return (SmasherStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upOneHanded();
	}
	
	public int getMag(){
		return getOwner().getStats().getOneHanded();
	}
}
