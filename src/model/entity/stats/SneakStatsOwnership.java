package model.entity.stats;

import view.utility.ObjectRenderer;
import model.entity.Entity;

public class SneakStatsOwnership extends StatsOwnership{
	/* -------------------- SERVICES -------------------- */
	protected SneakStats generateStats(){
		return new SneakStats();
	}
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public SneakStatsOwnership(Entity owner){
		super(owner);
	}
	
	/* -------------------- ACCESSORS -------------------- */

	public SneakStats getStats(){
		return (SneakStats) super.getStats();
	}
	
	/* -------------------- LEVEL UPS COMMANDS -------------------- */
	public boolean upPickpocket(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyPickpocket(1);
		return true;
	}
	public boolean upTrapping(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyTrapping(1);
		return true;
	}
	public boolean upCreep(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyCreep(1);
		return true;
	}
	public boolean upRangedWeapon(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyRangedWeapon(1);
		return true;
	}
	
	/* -------------------- VISITORS -------------------- */
	public void accept(SneakStatsVisitor visitor){
		getStats().accept(visitor);
	}

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
