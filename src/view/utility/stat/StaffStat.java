package view.utility.stat;

import model.entity.stats.StatsOwnership;
import model.entity.stats.SummonerStatsOwnership;


public class StaffStat extends Stat {
	public StaffStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SummonerStatsOwnership getOwner(){
		return (SummonerStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upStaff();
	}
	
	public int getMag(){
		return getOwner().getStats().getStaff();
	}
}
