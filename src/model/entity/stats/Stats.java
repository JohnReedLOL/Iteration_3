/**
 * Stats is the base class for all specific Stats classes belonging to specific occupations. It contains attributes and skills
 * shared by all occupations. 
 * @author - Matthew Kroeze
 * @version 1.0.0
 * Last edited 2015-04-16
 */

package model.entity.stats;

import java.util.Random;

public class Stats {
	private int currentLife; //may not be greater than maxLife
	private int currentMana; //may not be greater than maxMana
	private int strength;
	private int agility;
	private int intellect;
	private int hardiness;
	private int experience;
	private int movement;
	private int bindWounds;
	private int observation;
	private int bargain;
	private int weaponModifier;
	private int armorModifier;
	
	/* -------------------- HELPERS -------------------- */
	private int min(int a, int b){
		return a > b ? b : a;
	}
	private int max(int a, int b){
		return a < b ? b : a;
	}
	private int bindToLifeRange(int amount){
		return min(amount, getMaxLife());
	}
	private int bindToManaRange(int amount){
		return min(amount, getMaxMana());
	}
	private double affinityFactor(){
		return 1 + (getAffinity()/10000);
	}
	private boolean successfulHit(int amount){
		Random generator = new Random();
		if((generator.nextDouble()+generator.nextDouble())*getDefense() > amount) return false;
		return true;
	}
	/* -------------------- SERVICES -------------------- */
	/**
	 * Returns damage amount after mitigation is applied
	 * @param amount damage to be mitigated
	 * @return corrected amount after mitigation
	 */
	protected int mitigateDamage(int amount){
		//in case of "real" damage
		if(amount > 0){
			//check for miss on positive amounts
			if(!successfulHit(amount)) return 0;
			//don't let armor turn it into a heal
			return max(amount - getArmor(),0);
		}
		//in case of "healing" damage
		else{
			//don't let armor turn it into "real" damage
			return min(amount + getArmor(),0);
		}
	}
	/**
	 * Returns effect amount after mitigation is applied
	 * @param amount effect to be mitigated
	 * @return corrected amount after mitigation
	 */
	protected int mitigateEffect(int amount){
		return (int) (amount / affinityFactor());
	}
	
	/**
	 * Returns effect amount after intensification is applied
	 * @param amount effect to be intensified
	 * @return corrected amount after intensification
	 */
	protected int intensify(int amount){
		return (int) (amount * affinityFactor());
	}
	
	/* -------------------- CONSTRUCTORS -------------------- */
	
	public Stats(){
		currentLife = 0;
		currentMana = 0;
		strength = 0;
		agility = 0;
		intellect = 0;
		hardiness = 0;
		experience = 0;
		movement = 0;
		bindWounds = 0;
		observation = 0;
		bargain = 0;
	}
	
	/* -------------------- PRIMARY ATTRIBUTES AND SKILLS -------------------- */
	/* ---------- CURRENT LIFE ---------- */
	/**
	 * Getter for current life.
	 * @return amount of current life.
	 */
	public int getCurrentLife(){
		return currentLife;
	}
	/**
	 * Applies a mitigated modifier to current life.
	 * Negative damage is mitigated and then applied as a heal.
	 * @param modifier amount to be mitigated. 
	 * @return actual damage dealt after mitigation.
	 */
	public int dealDamage(int modifier){
		int amount = mitigateDamage(modifier);
		currentLife -= amount;
		currentLife = bindToLifeRange(currentLife);
		return amount;
	}
	/**
	 * Applies an intensified modifier to current life.
	 * Negative healing is intensified and then applied as damage.
	 * @param modifier amount to be intensified. 
	 * @return actual healing after intensification.
	 */
	public int healDamage(int modifier){
		int amount = intensify(modifier);
		currentLife += amount;
		currentLife = bindToLifeRange(currentLife);
		return amount;
	}
	/**
	 * Modifies current life by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyCurrentLife(int modifier){
		currentLife += modifier;
		currentLife = bindToLifeRange(currentLife);
	}
	/**
	 * Sets current life to specified amount.
	 * @param value the new current life. 
	 */
	public void setCurrentLife(int value){
		currentLife = value;
		currentLife = bindToLifeRange(currentLife);
	}
	
	/* ---------- CURRENT MANA ---------- */
	/**
	 * Getter for current mana.
	 * @return amount of current mana.
	 */
	public int getCurrentMana(){
		return currentMana;
	}
	/**
	 * Applies a mitigated modifier to current mana.
	 * Negative mana burn is mitigated and then applied as a heal.
	 * @param modifier amount to be mitigated. 
	 * @return actual mana burn after mitigation.
	 */
	public int burnMana(int modifier){
		int amount = mitigateEffect(modifier);
		currentMana -= amount;
		currentMana = bindToManaRange(currentMana);
		return amount;
	}
	/**
	 * Applies an intensified modifier to current mana.
	 * Negative mana restoration is intensified and then applied as burn.
	 * @param modifier amount to be intensified. 
	 * @return actual mana restoration after intensification.
	 */
	public int restoreMana(int modifier){
		int amount = intensify(modifier);
		currentMana += amount;
		currentMana = bindToManaRange(currentMana);
		return amount;
	}
	/**
	 * Modifies current mana by specified amount.
	 * @param modifier amount of change
	 */
	public void modifyCurrentMana(int modifier){
		currentMana += modifier;
		currentMana = bindToManaRange(currentMana);
	}
	/**
	 * Sets current mana to specified amount.
	 * @param value the new current mana. 
	 */
	public void setCurrentMana(int value){
		currentMana = value;
		currentMana = bindToManaRange(currentMana);
	}
	
	/* ---------- STRENGTH ---------- */
	/**
	 * Getter for strength.
	 * @return amount of strength.
	 */
	public int getStrength(){
		return strength;
	}
	/**
	 * Applies a mitigated modifier to strength.
	 * Negative strength debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual strength change after mitigation.
	 */
	public int debuffStrength(int modifier){
		int amount = mitigateEffect(modifier);
		strength -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to strength.
	 * Negative strength buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual strength change after intensification.
	 */
	public int buffStrength(int modifier){
		int amount = intensify(modifier);
		strength += amount;
		return amount;
	}
	/**
	 * Modifies strength by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyStrength(int modifier){
		strength += modifier;
	}
	/**
	 * Sets strength to specified amount.
	 * @param value the new strength
	 */
	public void setStrength(int value){
		strength = value;
	}
	
	/* ---------- AGILITY ---------- */
	/**
	 * Getter for agility.
	 * @return amount of agility.
	 */
	public int getAgility(){
		return agility;
	}
	/**
	 * Applies a mitigated modifier to agility.
	 * Negative agility debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual agility change after mitigation.
	 */
	public int debuffAgility(int modifier){
		int amount = mitigateEffect(modifier);
		agility -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to agility.
	 * Negative agility buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual agility change after intensification.
	 */
	public int buffAgility(int modifier){
		int amount = intensify(modifier);
		agility += amount;
		return amount;
	}
	/**
	 * Modifies agility by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyAgility(int modifier){
		agility += modifier;
	}
	/**
	 * Sets agility to specified amount.
	 * @param value the new agility
	 */
	public void setAgility(int value){
		agility = value;
	}
	
	/* ---------- INTELLECT ---------- */
	/**
	 * Getter for intellect.
	 * @return amount of intellect.
	 */
	public int getIntellect(){
		return intellect;
	}
	/**
	 * Applies a mitigated modifier to intellect.
	 * Negative intellect debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual intellect change after mitigation.
	 */
	public int debuffIntellect(int modifier){
		int amount = mitigateEffect(modifier);
		intellect -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to intellect.
	 * Negative intellect buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual intellect change after intensification.
	 */
	public int buffIntellect(int modifier){
		int amount = intensify(modifier);
		intellect += amount;
		return amount;
	}
	/**
	 * Modifies intellect by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyIntellect(int modifier){
		intellect += modifier;
	}
	/**
	 * Sets intellect to specified amount.
	 * @param value the new intellect
	 */
	public void setIntellect(int value){
		intellect = value;
	}
	
	/* ---------- HARDINESS ---------- */
	/**
	 * Getter for hardiness.
	 * @return amount of hardiness.
	 */
	public int getHardiness(){
		return hardiness;
	}
	/**
	 * Applies a mitigated modifier to hardiness.
	 * Negative hardiness debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual hardiness change after mitigation.
	 */
	public int debuffHardiness(int modifier){
		int amount = mitigateEffect(modifier);
		hardiness -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to hardiness.
	 * Negative hardiness buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual hardiness change after intensification.
	 */
	public int buffHardiness(int modifier){
		int amount = intensify(modifier);
		hardiness += amount;
		return amount;
	}
	/**
	 * Modifies hardiness by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyHardiness(int modifier){
		hardiness += modifier;
	}
	/**
	 * Sets hardiness to specified amount.
	 * @param value the new hardiness
	 */
	public void setHardiness(int value){
		hardiness = value;
	}
	
	/* ---------- EXPERIENCE ---------- */
	/**
	 * Getter for experience.
	 * @return amount of experience.
	 */
	public int getExperience(){
		return experience;
	}
	/**
	 * Applies a mitigated modifier to experience.
	 * Negative experience debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual experience change after mitigation.
	 */
	public int debuffExperience(int modifier){
		int amount = mitigateEffect(modifier);
		experience -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to experience.
	 * Negative experience buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual experience change after intensification.
	 */
	public int buffExperience(int modifier){
		int amount = intensify(modifier);
		experience += amount;
		return amount;
	}
	/**
	 * Modifies experience by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyExperience(int modifier){
		experience += modifier;
	}
	/**
	 * Sets experience to specified amount.
	 * @param value the new experience
	 */
	public void setExperience(int value){
		experience = value;
	}
	
	/* ---------- MOVEMENT ---------- */
	/**
	 * Getter for movement.
	 * @return amount of movement.
	 */
	public int getMovement(){
		return movement;
	}
	/**
	 * Applies a mitigated modifier to movement.
	 * Negative movement debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual movement change after mitigation.
	 */
	public int debuffMovement(int modifier){
		int amount = mitigateEffect(modifier);
		movement -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to movement.
	 * Negative movement buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual movement change after intensification.
	 */
	public int buffMovement(int modifier){
		int amount = intensify(modifier);
		movement += amount;
		return amount;
	}
	/**
	 * Modifies movement by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyMovement(int modifier){
		movement += modifier;
	}
	/**
	 * Sets movement to specified amount.
	 * @param value the new movement
	 */
	public void setMovement(int value){
		movement = value;
	}
	
	/* ---------- BIND WOUNDS ---------- */
	/**
	 * Getter for bindWounds.
	 * @return amount of bindWounds.
	 */
	public int getBindWounds(){
		return bindWounds;
	}
	/**
	 * Applies a mitigated modifier to bindWounds.
	 * Negative bindWounds debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual bindWounds change after mitigation.
	 */
	public int debuffBindWounds(int modifier){
		int amount = mitigateEffect(modifier);
		bindWounds -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to bindWounds.
	 * Negative bindWounds buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual bindWounds change after intensification.
	 */
	public int buffBindWounds(int modifier){
		int amount = intensify(modifier);
		bindWounds += amount;
		return amount;
	}
	/**
	 * Modifies bindWounds by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyBindWounds(int modifier){
		bindWounds += modifier;
	}
	/**
	 * Sets bindWounds to specified amount.
	 * @param value the new bindWounds
	 */
	public void setBindWounds(int value){
		bindWounds = value;
	}
	
	/* ---------- OBSERVATION ---------- */
	/**
	 * Getter for observation.
	 * @return amount of observation.
	 */
	public int getObservation(){
		return observation;
	}
	/**
	 * Applies a mitigated modifier to observation.
	 * Negative observation debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual observation change after mitigation.
	 */
	public int debuffObservation(int modifier){
		int amount = mitigateEffect(modifier);
		observation -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to observation.
	 * Negative observation buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual observation change after intensification.
	 */
	public int buffObservation(int modifier){
		int amount = intensify(modifier);
		observation += amount;
		return amount;
	}
	/**
	 * Modifies observation by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyObservation(int modifier){
		observation += modifier;
	}
	/**
	 * Sets observation to specified amount.
	 * @param value the new observation
	 */
	public void setObservation(int value){
		observation = value;
	}
	
	/* ---------- BARGAIN ---------- */
	/**
	 * Getter for bargain.
	 * @return amount of bargain.
	 */
	public int getBargain(){
		return bargain;
	}
	/**
	 * Applies a mitigated modifier to bargain.
	 * Negative bargain debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual bargain change after mitigation.
	 */
	public int debuffBargain(int modifier){
		int amount = mitigateEffect(modifier);
		bargain -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to bargain.
	 * Negative bargain buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual bargain change after intensification.
	 */
	public int buffBargain(int modifier){
		int amount = intensify(modifier);
		bargain += amount;
		return amount;
	}
	/**
	 * Modifies bargain by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyBargain(int modifier){
		bargain += modifier;
	}
	/**
	 * Sets bargain to specified amount.
	 * @param value the new bargain
	 */
	public void setBargain(int value){
		bargain = value;
	}
	
	/* -------------------- OTHER ATTRIBUTES -------------------- */
	/**
	 * Getter for weapon modifier to attack
	 * @return current weapon modifier
	 */
	public int getWeaponModifier(){
		return weaponModifier;
	}
	/**
	 * Modifies current weapon modifier by specified amount
	 * @param amount change in weapon modifier
	 */
	public void modifyWeaponModifier(int amount){
		weaponModifier += amount;
	}
	/**
	 * Getter for armor modifier to damage mitigation
	 * @return current armor modifier
	 */

	public void setWeaponModifier(int wm) {
		weaponModifier = wm;
	}
	public int getArmorModifier(){
		return armorModifier;
	}
	/**
	 * Modifies the current armor modifier by specified amount
	 * @param amount change in armor modifier
	 */
	public void modifyArmorModifier(int amount){
		armorModifier += amount;
	}
	
	/* -------------------- DERIVED ATTRIBUTES -------------------- */
	/**
	 * Getter for level
	 * @return current level
	 */

	public void setArmorModifier(int am) {
		armorModifier = am;
	}
	public int getLevel(){
		return getExperience() / 10000;
	}
	/**
	 * Getter for max life
	 * @return current max life
	 */
	public int getMaxLife(){
		return getHardiness() + getLevel();
	}
	/**
	 * Getter for max mana
	 * @return current max mana
	 */
	public int getMaxMana(){
		return getIntellect() + getLevel();
	}
	/**
	 * Getter for offense
	 * @return current offense
	 */
	public int getOffense(){
		return getStrength() + getLevel() + getWeaponModifier();
	}
	/**
	 * Getter for defense
	 * @return current defense
	 */
	public int getDefense(){
		return getAgility() + getLevel();
	}
	/**
	 * Getter for armor
	 * @return current armor
	 */
	public int getArmor(){
		return getHardiness() + getArmorModifier();
	}
	/**
	 * Getter for affinity
	 * @return current affinity
	 */
	public int getAffinity(){
		return getIntellect() + getLevel() + getAgility();
	}
	public void accept(StatsVisitor visitor){
		visitor.visit(this);
	}

}
