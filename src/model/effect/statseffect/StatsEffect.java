package model.effect.statseffect;

import model.effect.Effect;
import model.entity.Entity;
import model.entity.stats.StatsVisitor;

public abstract class StatsEffect implements Effect, StatsVisitor{
	private int magnitude;
	
	/* -------------------- CONSTRUCTORS -------------------- */
	StatsEffect(int magnitude){
		this.magnitude = magnitude;
	}
	
	/* -------------------- ACCESSORS -------------------- */
	public int getMagnitude(){
		return magnitude;
	}
	
	/* -------------------- MUTATORS -------------------- */
	public void setMagnitude(int value){
		magnitude = value;
	}
	
	/* -------------------- INTERFACE IMPLEMENTATIONS -------------------- */
	public void performEffect(Entity target){
		target.accept((StatsVisitor) this);
	}
}
