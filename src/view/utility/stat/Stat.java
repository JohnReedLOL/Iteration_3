package view.utility.stat;

import model.entity.stats.StatsOwnership;


public abstract class Stat {
	private String name;
	private StatsOwnership owner;
	
	public Stat(String nam, StatsOwnership p){
		name = nam;
		owner = p;
	}
	
	public String getName(){
		return name;
	}
	
	public abstract void level();
	public abstract int getMag();
	protected StatsOwnership getOwner(){
		return owner;
	}
}
