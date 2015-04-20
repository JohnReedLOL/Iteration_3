package model.effect.statseffect;

import model.entity.stats.Stats;

public class LevelUp extends StatsEffect  {
	public LevelUp(int mag){
		super(mag);
	}
	
	public void visit(Stats stats){
		stats.levelUp();
	}
}
