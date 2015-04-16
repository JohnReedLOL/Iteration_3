package model.entity.stats;

public class SneakStats extends Stats {
	private int pickpocket;
	private int trapping;
	private int creep;
	private int rangedWeapon;
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public SneakStats(){
		super();
		pickpocket = 0;
		trapping = 0;
		creep = 0;
		rangedWeapon = 0;
	}
	
	/* -------------------- SKILLS -------------------- */
	/* ---------- PICKPOCKET ---------- */
	/**
	 * Getter for pickpocket.
	 * @return amount of pickpocket.
	 */
	public int getPickpocket(){
		return pickpocket;
	}
	/**
	 * Applies a mitigated modifier to pickpocket.
	 * Negative pickpocket debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual pickpocket change after mitigation.
	 */
	public int debuffPickpocket(int modifier){
		int amount = mitigateEffect(modifier);
		pickpocket -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to pickpocket.
	 * Negative pickpocket buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual pickpocket change after intensification.
	 */
	public int buffPickpocket(int modifier){
		int amount = intensify(modifier);
		pickpocket += amount;
		return amount;
	}
	/**
	 * Modifies pickpocket by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyPickpocket(int modifier){
		pickpocket += modifier;
	}
	/**
	 * Sets pickpocket to specified amount.
	 * @param value the new pickpocket
	 */
	public void setPickpocket(int value){
		pickpocket = value;
	}
	
	/* ---------- TRAPPING ---------- */
	/**
	 * Getter for trapping.
	 * @return amount of trapping.
	 */
	public int getTrapping(){
		return trapping;
	}
	/**
	 * Applies a mitigated modifier to trapping.
	 * Negative trapping debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual trapping change after mitigation.
	 */
	public int debuffTrapping(int modifier){
		int amount = mitigateEffect(modifier);
		trapping -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to trapping.
	 * Negative trapping buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual trapping change after intensification.
	 */
	public int buffTrapping(int modifier){
		int amount = intensify(modifier);
		trapping += amount;
		return amount;
	}
	/**
	 * Modifies trapping by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyTrapping(int modifier){
		trapping += modifier;
	}
	/**
	 * Sets trapping to specified amount.
	 * @param value the new trapping
	 */
	public void setTrapping(int value){
		trapping = value;
	}
	
	/* ---------- CREEP ---------- */
	/**
	 * Getter for creep.
	 * @return amount of creep.
	 */
	public int getCreep(){
		return creep;
	}
	/**
	 * Applies a mitigated modifier to creep.
	 * Negative creep debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual creep change after mitigation.
	 */
	public int debuffCreep(int modifier){
		int amount = mitigateEffect(modifier);
		creep -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to creep.
	 * Negative creep buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual creep change after intensification.
	 */
	public int buffCreep(int modifier){
		int amount = intensify(modifier);
		creep += amount;
		return amount;
	}
	/**
	 * Modifies creep by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyCreep(int modifier){
		creep += modifier;
	}
	/**
	 * Sets creep to specified amount.
	 * @param value the new creep
	 */
	public void setCreep(int value){
		creep = value;
	}
	
	/* ---------- RANGED WEAPON ---------- */
	/**
	 * Getter for rangedWeapon.
	 * @return amount of rangedWeapon.
	 */
	public int getRangedWeapon(){
		return rangedWeapon;
	}
	/**
	 * Applies a mitigated modifier to rangedWeapon.
	 * Negative rangedWeapon debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual rangedWeapon change after mitigation.
	 */
	public int debuffRangedWeapon(int modifier){
		int amount = mitigateEffect(modifier);
		rangedWeapon -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to rangedWeapon.
	 * Negative rangedWeapon buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual rangedWeapon change after intensification.
	 */
	public int buffRangedWeapon(int modifier){
		int amount = intensify(modifier);
		rangedWeapon += amount;
		return amount;
	}
	/**
	 * Modifies rangedWeapon by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyRangedWeapon(int modifier){
		rangedWeapon += modifier;
	}
	/**
	 * Sets rangedWeapon to specified amount.
	 * @param value the new rangedWeapon
	 */
	public void setRangedWeapon(int value){
		rangedWeapon = value;
	}
	
	/* -------------------- VISITORS -------------------- */
	public void accept(SneakStatsVisitor visitor){
		visitor.visit(this);
	}
}
