/*
 * Author: Matthew Kroeze
 * Date Last Modified: 2015-04-16
 */

/*
 * Note: if time permits, correct implementations of up()s in this class
 * to better utilize the rings of operations (e.g. use modifySkillPoints(-1) 
 * instead of --skillPoints)
 */
package model.entity.stats;

import java.util.ArrayList;
import java.util.List;

import model.entity.Entity;
import view.utility.ObjectRenderer;
import view.utility.stat.AgilityStat;
import view.utility.stat.BargainStat;
import view.utility.stat.BindWoundsStat;
import view.utility.stat.HardinessStat;
import view.utility.stat.IntellectStat;
import view.utility.stat.ObservationStat;
import view.utility.stat.Stat;
import view.utility.stat.StrengthStat;

public class StatsOwnership {
	private int skillPoints;
	private int statPoints;
	private Stats stats;
	private Entity owner;
	
	/* -------------------- SERVICES -------------------- */
	protected Stats generateStats(){
		return new Stats();
	}
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public StatsOwnership(Entity owner){
		this.stats = generateStats();
		stats.setOwnership(this);
		this.owner = owner;
		skillPoints = 10;
		statPoints = 10;
	}
	
	/* -------------------- ACCESSORS -------------------- */
	public int getSkillPoints(){
		return skillPoints;
	}
	public int getStatPoints(){
		return statPoints;
	}
	public Entity getOwner(){
		return owner;
	}
	public Stats getStats(){
		return stats;
	}
	public int getCurrentLife(){
		return stats.getCurrentLife();
	}
	public int getCurrentMana(){
		return stats.getCurrentMana();
	}
	public int getExperience(){
		return stats.getExperience();
	}
	public int getMovement(){
		return stats.getMovement();
	}
	public int getWeaponMod(){
		return stats.getWeaponModifier();
	}
	public int getArmorMod(){
		return stats.getArmorModifier();
	}
	public int getLevel(){
		return stats.getLevel();
	}
	public int getMaxLife(){
		return stats.getMaxLife();
	}
	public int getMaxMana(){
		return stats.getMaxMana();
	}
	public int getOffense(){
		return stats.getOffense();
	}
	public int getDefense(){
		return stats.getDefense();
	}
	public int getArmor(){
		return stats.getArmor();
	}
	public int getAffinity(){
		return stats.getAffinity();
	}
	
	/* -------------------- LEVEL UP COMMANDS -------------------- */
	public boolean upStrength(){
		if(statPoints <= 0) return false;
		--statPoints;
		stats.modifyStrength(1);
		return true;
	}
	public boolean upAgility(){
		if(statPoints <= 0) return false;
		--statPoints;
		stats.modifyAgility(1);
		return true;
	}
	public boolean upIntellect(){
		if(statPoints <= 0) return false;
		--statPoints;
		stats.modifyIntellect(1);
		return true;
	}
	public boolean upHardiness(){
		if(statPoints <= 0) return false;
		--statPoints;
		stats.modifyHardiness(1);
		return true;
	}
	public boolean upBindWounds(){
		if(skillPoints <= 0) return false;
		--skillPoints;
		stats.modifyBindWounds(1);
		return true;
	}
	public boolean upObservation(){
		if(skillPoints <= 0) return false;
		--skillPoints;
		stats.modifyObservation(1);
		return true;
	}
	public boolean upBargain(){
		if(skillPoints <= 0) return false;
		--skillPoints;
		stats.modifyBargain(1);
		return true;
	}
	
	/* -------------------- OTHER MUTATORS -------------------- */
	public void modifySkillPoints(int modifier){
		skillPoints += modifier;
	}
	public void modifyStatPoints(int modifier){
		statPoints += modifier;
	}
	public void setOwner(Entity owner) {
		this.owner = owner;
	}
	
	
	/* -------------------- VISITORS -------------------- */
	public void accept(StatsVisitor visitor){
		stats.accept(visitor);
	}

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
		return value;
	}
	
	
}
