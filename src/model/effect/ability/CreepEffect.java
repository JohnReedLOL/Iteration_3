package model.effect.ability;

import model.effect.Effect;
import model.entity.Entity;
import model.prerequisite.Prerequisite;
import model.prerequisite.RequireObservation;

public class CreepEffect implements Effect {
	private static Prerequisite creepReq = new RequireObservation(30);
	public void performEffect(Entity target){
		target.getDetectionMechanism().addDetectionRequirement(creepReq);
	}
	public static Prerequisite getRequirement(){
		return creepReq;
	}
}
