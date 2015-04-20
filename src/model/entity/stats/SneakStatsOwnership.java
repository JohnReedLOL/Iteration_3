package model.entity.stats;

import java.util.ArrayList;
import java.util.List;

import model.entity.Entity;
import view.utility.ObjectRenderer;
import view.utility.stat.AgilityStat;
import view.utility.stat.BargainStat;
import view.utility.stat.BindWoundsStat;
import view.utility.stat.CreepStat;
import view.utility.stat.HardinessStat;
import view.utility.stat.IntellectStat;
import view.utility.stat.ObservationStat;
import view.utility.stat.PickpocketStat;
import view.utility.stat.RangedWeaponStat;
import view.utility.stat.Stat;
import view.utility.stat.StrengthStat;
import view.utility.stat.TrapStat;

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
		value.add(new PickpocketStat("Pickpocket", this));
		value.add(new CreepStat("Creep", this));
		value.add(new TrapStat("Trapping", this));
		value.add(new RangedWeaponStat("Ranged Weapon", this));
		return value;
	}
}
