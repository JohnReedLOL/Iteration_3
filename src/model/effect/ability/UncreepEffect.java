package model.effect.ability;

import model.effect.Effect;
import model.effect.ability.CreepEffect;
import model.entity.Entity;

public class UncreepEffect implements Effect {
	public void performEffect(Entity target){
		target.getDetectionMechanism().removeDetectionRequirement(CreepEffect.getRequirement());
	}
}
