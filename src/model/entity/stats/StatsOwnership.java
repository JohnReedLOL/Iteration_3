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

import model.entity.Entity;
import model.entity.stats.Stats;

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
		this.owner = owner;
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
	public boolean upExperience(){
		if(statPoints <= 0) return false;
		--statPoints;
		stats.modifyExperience(1);
		return true;
	}
	public boolean upMovement(){
		if(statPoints <= 0) return false;
		--statPoints;
		stats.modifyMovement(1);
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
	
	
}
