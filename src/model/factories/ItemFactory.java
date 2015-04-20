package model.factories;

import model.effect.movementeffects.TeleportEffect;
import model.effect.statseffect.*;
import model.influence_set.InfluenceSet;
import model.influence_set.LinearInfluenceSet;
import model.item.interactive.InteractiveItem;
import model.item.sackbound.equip.EquipItem;
import model.item.sackbound.equip.WeaponItem;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.SecondLevelGameMap;
import model.map.direction.Direction;
import model.map.direction.NorthDirection;
import model.map.location.GrassTile;
import model.map.location.Location;
import model.prerequisite.RequireLevel;
import model.prerequisite.RequireRangedWeapon;

import java.util.ArrayList;

public class ItemFactory {
    public static EquipItem generateLevel2RobeItem() {
        EquipItem ret = new EquipItem("Better Mage Robe", "Better than what you got.", EquipItem.EquipSlot.TORSO);
        ret.addEquipPrerequisite(new RequireLevel(2));
        ret.addEquipEffect(new ModifyIntellect(4));
        ret.addEquipEffect(new ModifyEnchantment(3));
        ret.addEquipEffect(new ModifyBane(1));
        ret.addEquipEffect(new ModifyArmorModifier(1));
        ret.addUnequipEffect(new ModifyIntellect(-4));
        ret.addUnequipEffect(new ModifyEnchantment(-3));
        ret.addUnequipEffect(new ModifyBane(-1));
        ret.addUnequipEffect(new ModifyArmorModifier(-1));

        return ret;
    }

    public static EquipItem generateLevel5Robe() {
        EquipItem ret = new EquipItem("Superior Robe", "LEEEEERROOOYYY JANKINNNSSS", EquipItem.EquipSlot.TORSO);
        ret.addEquipPrerequisite(new RequireLevel(5));
        ret.addEquipEffect(new ModifyIntellect(14));
        ret.addEquipEffect(new ModifyEnchantment(5));
        ret.addEquipEffect(new ModifyBane(3));
        ret.addEquipEffect(new ModifyBindWounds(4));
        ret.addUnequipEffect(new ModifyIntellect(-14));
        ret.addUnequipEffect(new ModifyEnchantment(-5));
        ret.addUnequipEffect(new ModifyBane(-3));
        ret.addUnequipEffect(new ModifyBindWounds(-4));

        return ret;
    }

    public static EquipItem generateLevel3Hood() {
        EquipItem ret = new EquipItem("Little Red in the Hood", "Roll MOB deep", EquipItem.EquipSlot.HEAD);
        ret.addEquipPrerequisite(new RequireLevel(3));
        ret.addEquipEffect(new ModifyIntellect(18));
        ret.addEquipEffect(new ModifyBane(2));
        ret.addEquipEffect(new ModifyBindWounds(4));
        ret.addUnequipEffect(new ModifyIntellect(-18));
        ret.addUnequipEffect(new ModifyBane(-2));
        ret.addUnequipEffect(new ModifyBindWounds(-4));

        return ret;
    }

    public static EquipItem generateLevel3ChainMail() {
        EquipItem ret = new EquipItem("N00b Chain Mail", "Do yo' chain hang low?", EquipItem.EquipSlot.TORSO);
        ret.addEquipPrerequisite(new RequireLevel(3));
        ret.addEquipEffect(new ModifyHardiness(7));
        ret.addEquipEffect(new ModifyArmorModifier(6));
        ret.addUnequipEffect(new ModifyHardiness(-7));
        ret.addUnequipEffect(new ModifyArmorModifier(-6));

        return ret;
    }

    public static EquipItem generateLevel6Plate() {
        EquipItem ret = new EquipItem("Not so n00b plate", "This will slow ya down.", EquipItem.EquipSlot.TORSO);
        ret.addEquipPrerequisite(new RequireLevel(6));
        ret.addEquipEffect(new ModifyHardiness(9));
        ret.addEquipEffect(new ModifyArmorModifier(10));
        ret.addEquipEffect(new ModifyMovement(-2));
        ret.addUnequipEffect(new ModifyHardiness(-9));
        ret.addUnequipEffect(new ModifyArmorModifier(-10));
        ret.addUnequipEffect(new ModifyMovement(2));

        return ret;
    }

    public static EquipItem generateLevel4SummonerTotem() {
        EquipItem ret = new EquipItem("Totem of Awesome", "You really don't know how awesome this is.", EquipItem.EquipSlot.OFFHAND);
        ret.addEquipPrerequisite(new RequireLevel(4));
        ret.addEquipEffect(new ModifyIntellect(8));
        ret.addEquipEffect(new ModifyBane(2));
        ret.addEquipEffect(new ModifyBoon(1));
        ret.addUnequipEffect(new ModifyIntellect(-8));
        ret.addUnequipEffect(new ModifyBane(-2));
        ret.addUnequipEffect(new ModifyBoon(-1));

        return ret;
    }

    public static EquipItem generateLevel3Shield() {
        EquipItem ret = new EquipItem("Wooden Shield", "It kinda sucks.", EquipItem.EquipSlot.OFFHAND);
        ret.addEquipPrerequisite(new RequireLevel(3));
        ret.addEquipEffect(new ModifyArmorModifier(2));
        ret.addEquipEffect(new ModifyHardiness(1));
        ret.addEquipEffect(new ModifyBindWounds(1));
        ret.addEquipEffect(new ModifyArmorModifier(-2));
        ret.addEquipEffect(new ModifyHardiness(-1));
        ret.addEquipEffect(new ModifyBindWounds(-1));

        return ret;
    }

    public static EquipItem generateLevel3ChainHood() {
        EquipItem ret = new EquipItem("Chain Hood", "Look like a knight!", EquipItem.EquipSlot.HEAD);
        ret.addEquipPrerequisite(new RequireLevel(3));
        ret.addEquipEffect(new ModifyArmorModifier(4));
        ret.addEquipEffect(new ModifyHardiness(2));
        ret.addUnequipEffect(new ModifyArmorModifier(-4));
        ret.addUnequipEffect(new ModifyHardiness(-2));

        return ret;
    }

    public static WeaponItem generateLevel1Bow() {
        ArrayList<InfluenceSet> influences = new ArrayList<InfluenceSet>();
        influences.add(new LinearInfluenceSet(new NorthDirection(), 3, new GrassTile()));
        WeaponItem ret = new WeaponItem("Shortbow", "More pew pew!", EquipItem.EquipSlot.MAINHAND, influences);
        ret.addEquipPrerequisite(new RequireLevel(1));
        ret.addEquipPrerequisite(new RequireRangedWeapon(0));
        ret.addEquipEffect(new ModifyAgility(2));
        ret.addEquipEffect(new ModifyRangedWeapon(2));
        ret.addUnequipEffect(new ModifyAgility(-2));
        ret.addUnequipEffect(new ModifyRangedWeapon(-2));

        return ret;
    }

    public static WeaponItem generateLevel3Bow() {
        ArrayList<InfluenceSet> influences = new ArrayList<InfluenceSet>();
        influences.add(new LinearInfluenceSet(new NorthDirection(), 5, new GrassTile()));
        WeaponItem ret = new WeaponItem("Better Shortbow", "Even more pew pew!", EquipItem.EquipSlot.MAINHAND, influences);
        ret.addEquipPrerequisite(new RequireLevel(3));
        ret.addEquipPrerequisite(new RequireRangedWeapon(2));
        ret.addEquipEffect(new ModifyAgility(5));
        ret.addEquipEffect(new ModifyRangedWeapon(3));
        ret.addUnequipEffect(new ModifyAgility(-5));
        ret.addUnequipEffect(new ModifyRangedWeapon(-3));

        return ret;
    }

    public static WeaponItem generateLevel2ThrowingKnives() {
        ArrayList<InfluenceSet> influences = new ArrayList<InfluenceSet>();
        influences.add(new LinearInfluenceSet(new NorthDirection(), 4, new GrassTile()));
        WeaponItem ret = new WeaponItem("Throwing Knives", "Feel (almost) like a ninja.", EquipItem.EquipSlot.MAINHAND, influences);
        ret.addEquipPrerequisite(new RequireLevel(2));
        ret.addEquipPrerequisite(new RequireRangedWeapon(1));
        ret.addEquipEffect(new ModifyAgility(4));
        ret.addEquipEffect(new ModifyRangedWeapon(2));
        ret.addUnequipEffect(new ModifyAgility(-4));
        ret.addUnequipEffect(new ModifyRangedWeapon(-2));

        return ret;
    }

    public static EquipItem generateLevel4Coif() {
        EquipItem ret = new EquipItem("Coif of Sight", "Even more pew pew!", EquipItem.EquipSlot.MAINHAND);
        ret.addEquipPrerequisite(new RequireLevel(3));
        ret.addEquipPrerequisite(new RequireRangedWeapon(2));
        ret.addEquipEffect(new ModifyAgility(5));
        ret.addEquipEffect(new ModifyRangedWeapon(3));
        ret.addUnequipEffect(new ModifyAgility(-5));
        ret.addUnequipEffect(new ModifyRangedWeapon(-3));

        return ret;
    }
}
