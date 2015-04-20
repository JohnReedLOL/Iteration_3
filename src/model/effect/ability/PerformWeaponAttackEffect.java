package model.effect.ability;

import model.effect.Effect;
import model.entity.Entity;

public class PerformWeaponAttackEffect implements Effect {
	public void performEffect(Entity target){
		target.useWeapon();
	}
}
