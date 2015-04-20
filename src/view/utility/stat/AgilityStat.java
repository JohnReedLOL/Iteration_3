package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class AgilityStat extends Stat {
	public AgilityStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upAgility();
	}
	
	public int getMag(){
		return getOwner().getStats().getAgility();
	}
}
