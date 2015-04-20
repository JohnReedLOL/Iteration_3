package view.utility.stat;

import model.entity.stats.StatsOwnership;


public class ObservationStat extends Stat {
	public ObservationStat(String nam, StatsOwnership p){
		super(nam, p);
	}
	
	public void level(){
		getOwner().upObservation();
	}
	
	public int getMag(){
		return getOwner().getStats().getObservation();
	}
}
