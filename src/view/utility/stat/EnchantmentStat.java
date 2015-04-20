package view.utility.stat;

import model.entity.stats.StatsOwnership;
import model.entity.stats.SummonerStatsOwnership;


public class EnchantmentStat extends Stat {
	public EnchantmentStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public SummonerStatsOwnership getOwner(){
		return (SummonerStatsOwnership) super.getOwner();
	}
	
	public void level(){
		getOwner().upEnchantment();
	}
	
	public int getMag(){
		return getOwner().getStats().getEnchantment();
	}
}
