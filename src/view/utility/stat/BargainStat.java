package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class BargainStat extends Stat {
	public BargainStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upBargain();
	}
	
	public int getMag(){
		return getOwner().getStats().getBargain();
	}
}
