package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class BindWoundsStat extends Stat {
	public BindWoundsStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upBindWounds();
	}
	
	public int getMag(){
		return getOwner().getStats().getBindWounds();
	}
}
