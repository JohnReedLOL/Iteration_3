package model.effect;

import model.entity.Entity;

public class PerformWeaponAttackEffect implements Effect {
	public void performEffect(Entity target){
		target.useWeapon();
	}
}
