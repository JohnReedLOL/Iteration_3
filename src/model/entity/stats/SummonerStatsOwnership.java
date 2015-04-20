package model.entity.stats;

import java.util.ArrayList;
import java.util.List;

import model.entity.Entity;
import view.utility.ObjectRenderer;
import view.utility.stat.AgilityStat;
import view.utility.stat.BaneStat;
import view.utility.stat.BargainStat;
import view.utility.stat.BindWoundsStat;
import view.utility.stat.BoonStat;
import view.utility.stat.EnchantmentStat;
import view.utility.stat.HardinessStat;
import view.utility.stat.IntellectStat;
import view.utility.stat.ObservationStat;
import view.utility.stat.StaffStat;
import view.utility.stat.Stat;
import view.utility.stat.StrengthStat;

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
		value.add(new BoonStat("Boon", this));
		value.add(new BaneStat("Bane", this));
		value.add(new EnchantmentStat("Enchantment", this));
		value.add(new StaffStat("Staff", this));
		return value;
	}
	
}
