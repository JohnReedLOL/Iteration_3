package view.utility.stat;

import model.entity.stats.StatsOwnership;
import model.entity.stats.SummonerStatsOwnership;


public class BaneStat extends Stat {
	public BaneStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SummonerStatsOwnership getOwner(){
		return (SummonerStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upBane();
	}
	
	public int getMag(){
		return getOwner().getStats().getBane();
	}
}
