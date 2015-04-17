package model.entity.stats;

import model.entity.Entity;

public class SummonerStatsOwnership extends StatsOwnership{
	/* -------------------- SERVICES -------------------- */
	protected SummonerStats generateStats(){
		return new SummonerStats();
	}
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public SummonerStatsOwnership(Entity owner){
		super(owner);
	}
	
	/* -------------------- ACCESSORS -------------------- */

	public SummonerStats getStats(){
		return (SummonerStats) super.getStats();
	}
	
	/* -------------------- LEVEL UPS COMMANDS -------------------- */
	public boolean upBane(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyBane(1);
		return true;
	}
	public boolean upBoon(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyBoon(1);
		return true;
	}
	public boolean upEnchantment(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyEnchantment(1);
		return true;
	}
	public boolean upStaff(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyStaff(1);
		return true;
	}
	
	/* -------------------- VISITORS -------------------- */
	public void accept(SummonerStatsVisitor visitor){
		getStats().accept(visitor);
	}
	
}
