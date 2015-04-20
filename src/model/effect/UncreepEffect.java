package model.effect;

import model.entity.Entity;
import model.prerequisite.RequireObservation;

public class UncreepEffect implements Effect {
	public void performEffect(Entity target){
		target.getDetectionMechanism().removeDetectionRequirement(CreepEffect.getRequirement());
	}
}
