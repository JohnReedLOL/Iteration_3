package model.entity.stats;

import java.util.ArrayList;
import java.util.List;

import model.entity.Entity;
import view.utility.ObjectRenderer;
import view.utility.stat.AgilityStat;
import view.utility.stat.BargainStat;
import view.utility.stat.BindWoundsStat;
import view.utility.stat.BrawlStat;
import view.utility.stat.HardinessStat;
import view.utility.stat.IntellectStat;
import view.utility.stat.ObservationStat;
import view.utility.stat.OneHandStat;
import view.utility.stat.Stat;
import view.utility.stat.StrengthStat;
import view.utility.stat.TwoHandStat;

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
	
	/* ------------------- VIEW STUFF -------------------- */
	public List<Stat> getViewStats(){
		List<Stat> value = new ArrayList<Stat>();
		value.add(new StrengthStat("Strength", this));
		value.add(new AgilityStat("Agility", this));
		value.add(new IntellectStat("Intellect", this));
		value.add(new HardinessStat("Hardiness", this));
		value.add(new BindWoundsStat("Bind Wounds", this));
		value.add(new ObservationStat("Observation", this));
		value.add(new BargainStat("Bargain", this));
		value.add(new OneHandStat("One-Handed", this));
		value.add(new TwoHandStat("Two-Handed", this));
		value.add(new BrawlStat("Brawl", this));
		return value;
	}
}
