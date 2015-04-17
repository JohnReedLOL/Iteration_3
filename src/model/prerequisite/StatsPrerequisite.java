package model.prerequisite;

import model.entity.Entity;
import model.entity.stats.StatsVisitor;

public abstract class StatsPrerequisite implements Prerequisite, StatsVisitor{
	public int magnitude;
	private boolean passed;
	
	StatsPrerequisite(int magnitude){
		this.magnitude = magnitude;
		passed = false;
	}
	
	public int getMagnitude(){
		return magnitude;
	}
	
	public void setMagnitude(int value){
		magnitude = value;
	}
	
	public boolean getPassed(){
		return passed;
	}
	
	public void setPassed(boolean value){
		passed = value;
	}
	
	public boolean meetsRequirement(Entity target){
		target.accept(this);
		boolean result = passed;
		passed = false;
		return result;
	}
}
