package model.entity.stats;

public class SummonerStats extends Stats {
	private int bane;
	private int boon;
	private int enchantment;
	private int staff;
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public SummonerStats(){
		super();
		bane = 0;
		boon = 0;
		enchantment = 0;
		staff = 0;
	}
	
	/* -------------------- SKILLS -------------------- */
	/* ---------- BANE ---------- */
	/**
	 * Getter for bane.
	 * @return amount of bane.
	 */
	public int getBane(){
		return bane;
	}
	/**
	 * Applies a mitigated modifier to bane.
	 * Negative bane debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual bane change after mitigation.
	 */
	public int debuffBane(int modifier){
		int amount = mitigateEffect(modifier);
		bane -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to bane.
	 * Negative bane buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual bane change after intensification.
	 */
	public int buffBane(int modifier){
		int amount = intensify(modifier);
		bane += amount;
		return amount;
	}
	/**
	 * Modifies bane by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyBane(int modifier){
		bane += modifier;
	}
	/**
	 * Sets bane to specified amount.
	 * @param value the new bane
	 */
	public void setBane(int value){
		bane = value;
	}
	
	/* ---------- BOON ---------- */
	/**
	 * Getter for boon.
	 * @return amount of boon.
	 */
	public int getBoon(){
		return boon;
	}
	/**
	 * Applies a mitigated modifier to boon.
	 * Negative boon debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual boon change after mitigation.
	 */
	public int debuffBoon(int modifier){
		int amount = mitigateEffect(modifier);
		boon -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to boon.
	 * Negative boon buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual boon change after intensification.
	 */
	public int buffBoon(int modifier){
		int amount = intensify(modifier);
		boon += amount;
		return amount;
	}
	/**
	 * Modifies boon by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyBoon(int modifier){
		boon += modifier;
	}
	/**
	 * Sets boon to specified amount.
	 * @param value the new boon
	 */
	public void setBoon(int value){
		boon = value;
	}
	
	/* ---------- ENCHANTMENT ---------- */
	/**
	 * Getter for enchantment.
	 * @return amount of enchantment.
	 */
	public int getEnchantment(){
		return enchantment;
	}
	/**
	 * Applies a mitigated modifier to enchantment.
	 * Negative enchantment debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual enchantment change after mitigation.
	 */
	public int debuffEnchantment(int modifier){
		int amount = mitigateEffect(modifier);
		enchantment -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to enchantment.
	 * Negative enchantment buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual enchantment change after intensification.
	 */
	public int buffEnchantment(int modifier){
		int amount = intensify(modifier);
		enchantment += amount;
		return amount;
	}
	/**
	 * Modifies enchantment by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyEnchantment(int modifier){
		enchantment += modifier;
	}
	/**
	 * Sets enchantment to specified amount.
	 * @param value the new enchantment
	 */
	public void setEnchantment(int value){
		enchantment = value;
	}
	
	/* ---------- STAFF ---------- */
	/**
	 * Getter for staff.
	 * @return amount of staff.
	 */
	public int getStaff(){
		return staff;
	}
	/**
	 * Applies a mitigated modifier to staff.
	 * Negative staff debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual staff change after mitigation.
	 */
	public int debuffStaff(int modifier){
		int amount = mitigateEffect(modifier);
		staff -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to staff.
	 * Negative staff buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual staff change after intensification.
	 */
	public int buffStaff(int modifier){
		int amount = intensify(modifier);
		staff += amount;
		return amount;
	}
	/**
	 * Modifies staff by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyStaff(int modifier){
		staff += modifier;
	}
	/**
	 * Sets staff to specified amount.
	 * @param value the new staff
	 */
	public void setStaff(int value){
		staff = value;
	}
	
	/* -------------------- VISITORS -------------------- */
	public void accept(SummonerStatsVisitor visitor){
		visitor.visit(this);
	}
}
