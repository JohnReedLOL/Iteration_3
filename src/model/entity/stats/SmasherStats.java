package model.entity.stats;

public class SmasherStats extends Stats {
	private int oneHanded;
	private int twoHanded;
	private int brawl;
	
	/* -------------------- CONSTRUCTORS -------------------- */
	public SmasherStats(){
		super();
		oneHanded = 0;
		twoHanded = 0;
		brawl = 0;
	}
	
	/* -------------------- SKILLS -------------------- */
	/* ---------- ONE HANDED ---------- */
	/**
	 * Getter for oneHanded.
	 * @return amount of oneHanded.
	 */
	public int getOneHanded(){
		return oneHanded;
	}
	/**
	 * Applies a mitigated modifier to oneHanded.
	 * Negative oneHanded debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual oneHanded change after mitigation.
	 */
	public int debuffOneHanded(int modifier){
		int amount = mitigateEffect(modifier);
		oneHanded -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to oneHanded.
	 * Negative oneHanded buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual oneHanded change after intensification.
	 */
	public int buffOneHanded(int modifier){
		int amount = intensify(modifier);
		oneHanded += amount;
		return amount;
	}
	/**
	 * Modifies oneHanded by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyOneHanded(int modifier){
		oneHanded += modifier;
	}
	/**
	 * Sets oneHanded to specified amount.
	 * @param value the new oneHanded
	 */
	public void setOneHanded(int value){
		oneHanded = value;
	}
	
	/* ---------- TWO HANDED ---------- */
	/**
	 * Getter for twoHanded.
	 * @return amount of twoHanded.
	 */
	public int getTwoHanded(){
		return twoHanded;
	}
	/**
	 * Applies a mitigated modifier to twoHanded.
	 * Negative twoHanded debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual twoHanded change after mitigation.
	 */
	public int debuffTwoHanded(int modifier){
		int amount = mitigateEffect(modifier);
		twoHanded -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to twoHanded.
	 * Negative twoHanded buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual twoHanded change after intensification.
	 */
	public int buffTwoHanded(int modifier){
		int amount = intensify(modifier);
		twoHanded += amount;
		return amount;
	}
	/**
	 * Modifies twoHanded by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyTwoHanded(int modifier){
		twoHanded += modifier;
	}
	/**
	 * Sets twoHanded to specified amount.
	 * @param value the new twoHanded
	 */
	public void setTwoHanded(int value){
		twoHanded = value;
	}
	
	/* ---------- BRAWL ---------- */
	/**
	 * Getter for brawl.
	 * @return amount of brawl.
	 */
	public int getBrawl(){
		return brawl;
	}
	/**
	 * Applies a mitigated modifier to brawl.
	 * Negative brawl debuffs are mitigated and then applied as a buff.
	 * @param modifier amount to be mitigated. 
	 * @return actual brawl change after mitigation.
	 */
	public int debuffBrawl(int modifier){
		int amount = mitigateEffect(modifier);
		brawl -= amount;
		return amount;
	}
	/**
	 * Applies an intensified modifier to brawl.
	 * Negative brawl buffs are intensified and then applied as a debuff.
	 * @param modifier amount to be intensified. 
	 * @return actual brawl change after intensification.
	 */
	public int buffBrawl(int modifier){
		int amount = intensify(modifier);
		brawl += amount;
		return amount;
	}
	/**
	 * Modifies brawl by specified amount.
	 * @param modifier amount of change. 
	 */
	public void modifyBrawl(int modifier){
		brawl += modifier;
	}
	/**
	 * Sets brawl to specified amount.
	 * @param value the new brawl
	 */
	public void setBrawl(int value){
		brawl = value;
	}
	
	/* -------------------- VISITORS -------------------- */
	public void accept(SmasherStatsVisitor visitor){
		visitor.visit(this);
	}
}
