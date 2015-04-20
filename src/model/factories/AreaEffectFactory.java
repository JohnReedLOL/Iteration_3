package model.factories;

import model.effect.movementeffects.TeleportEffect;
import model.effect.statseffect.DealDamage;
import model.effect.statseffect.HealDamage;
import model.effect.statseffect.LevelUp;
import model.effect.statseffect.ModifyCurrentLife;
import model.map.AreaEffect;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.SecondLevelGameMap;

public class AreaEffectFactory {
	public static AreaEffect generateLevelUp(){
		AreaEffect effect = new AreaEffect();
		effect.addEffect(new LevelUp(1));
		return effect;
	}
	public static AreaEffect generateDeal10Damage(){
		AreaEffect effect = new AreaEffect();
		effect.addEffect(new DealDamage(10));
		return effect;
	}
	public static AreaEffect generateHeal10Damage(){
		AreaEffect effect = new AreaEffect();
		effect.addEffect(new HealDamage(10));
		return effect;
	}
	public static AreaEffect generateKill(){
		AreaEffect effect = new AreaEffect();
		effect.addEffect(new ModifyCurrentLife(Integer.MIN_VALUE));
		return effect;
	}
	public static AreaEffect generateTeleport(){
		AreaEffect effect = new AreaEffect();
		GameMap secondMap = new SecondLevelGameMap();
		GameWorld.getInstance().addMap(secondMap);
		effect.addEffect(new TeleportEffect(secondMap));
		return effect;
	}

}
