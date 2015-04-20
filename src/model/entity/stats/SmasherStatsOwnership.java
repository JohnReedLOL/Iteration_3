package model.entity.stats;

import view.utility.ObjectRenderer;
import model.entity.Entity;

public class SmasherStatsOwnership extends StatsOwnership{
	/* -------------------- SERVICES -------------------- */
	protected SmasherStats generateStats(){
		return new SmasherStats();
	}
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public SmasherStatsOwnership(Entity owner){
		super(owner);
	}
	
	/* -------------------- ACCESSORS -------------------- */

	public SmasherStats getStats(){
		return (SmasherStats) super.getStats();
	}
	
	/* -------------------- LEVEL UPS COMMANDS -------------------- */
	public boolean upOneHanded(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyOneHanded(1);
		return true;
	}
	public boolean upTwoHanded(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyTwoHanded(1);
		return true;
	}
	public boolean upBrawl(){
		if(getSkillPoints() <= 0) return false;
		modifySkillPoints(-1);
		getStats().modifyBrawl(1);
		return true;
	}
	
	/* -------------------- VISITORS -------------------- */
	public void accept(SmasherStatsVisitor visitor){
		getStats().accept(visitor);
	}

	@Override
	public void accept(ObjectRenderer mapObjectRenderer) {
		mapObjectRenderer.visit(this);
	}
}
