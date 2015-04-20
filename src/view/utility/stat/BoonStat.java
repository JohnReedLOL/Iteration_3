package view.utility.stat;

import model.entity.stats.StatsOwnership;
import model.entity.stats.SummonerStatsOwnership;


public class BoonStat extends Stat {
	public BoonStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SummonerStatsOwnership getOwner(){
		return (SummonerStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upBoon();
	}
	
	public int getMag(){
		return getOwner().getStats().getBoon();
	}
}
