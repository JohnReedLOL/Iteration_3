package model.factories;

import java.util.ArrayList;

import model.effect.*;
import model.effect.statseffect.*;
import model.entity.ability.Ability;
import model.influence_set.*;
import model.map.direction.NorthDirection;
import model.map.location.GrassTile;
import model.prerequisite.*;

public class AbilityFactory {
	/* ---------- THE ONE ABILITY TO RULE THEM ALL ---------- */
	 public static Ability generateBasicAttackAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new PerformWeaponAttackEffect());

        return new Ability(effects, learnReqs, useReqs, areas, costs, "Basic Attack");
    }
    /* ---------- GENERAL ABILITIES THAT ALL ENTITIES SHARE ---------- */
    public static Ability generateObservationAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new SetObservation(5));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireObservation(0));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new LinearInfluenceSet(new NorthDirection(), 1, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ObservationEffect(2));

        return new Ability(effects, learnReqs, useReqs, areas, costs, "Observation");
    }
    public static Ability generateBindWoundsAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new HealDamage(8));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(1));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireBindWounds(1));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new LinearInfluenceSet(new NorthDirection(), 0, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();

        return new Ability(effects, learnReqs, useReqs, areas, costs, "Bind Wounds");
    }
	 /* ---------- SMASHER ABILITIES ---------- */
    public static Ability generateSmasherHulkSmashBrawlAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(-10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(1));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireBrawl(1));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new RadialInfluenceSet(5, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();

        return new Ability(effects, learnReqs, useReqs, areas, costs,"HULK SMASH!");
    }

    public static Ability generateSmasherRageBrawlAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(-10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(1));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireBrawl(1));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new RadialInfluenceSet(5, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();

        return new Ability(effects, learnReqs, useReqs, areas, costs, "RAGE!");
    }
    
    /* ---------- SUMMONER ABILITIES ---------- */
    public static Ability generateSummonerLinearBaneAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(-10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(1));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(10));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new LinearInfluenceSet(new NorthDirection(), 5, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-10));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Linear Bane");
    }
    public static Ability generateSummonerAngularBaneAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(-10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(2));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(15));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new AngularInfluenceSet(new NorthDirection(), 5, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-15));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Angular Bane");
    }
    public static Ability generateSummonerRadialBaneAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(-12));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(3));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(20));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new RadialInfluenceSet(5, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-20));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Radial Bane");
    }
    public static Ability generateSummonerLinearBoonAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(1));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(10));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new LinearInfluenceSet(new NorthDirection(), 1, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-10));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Linear Boon");
    }
    public static Ability generateSummonerAngularBoonAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(15));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(2));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(15));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new AngularInfluenceSet(new NorthDirection(), 2, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-15));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Angular Boon");
    }
    public static Ability generateSummonerRadialBoonAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(12));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(3));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(20));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new RadialInfluenceSet(2, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-20));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Radial Boon");
    }
//    public static Ability generateSummonerVespaEnchantAbility() {
//        ArrayList<Effect> effects = new ArrayList<Effect>();
//
//        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
//        learnReqs.add(new RequireLevel(1));
//
//        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
//        useReqs.add(new RequireCurrentMP(20));
//
//        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
//        areas.add(new LinearInfluenceSet(new NorthDirection(), 1, new GrassTile()));
//
//        ArrayList<Effect> costs = new ArrayList<Effect>();
//        costs.add(new ModifyCurrentMana(-20));
//
//        return new Ability(effects, learnReqs, useReqs, areas, costs,"Vespa 'Enchant'");
//    }
//    public static Ability generateSummonerAngularBoonAbility() {
//        ArrayList<Effect> effects = new ArrayList<Effect>();
//        effects.add(new ModifyCurrentLife(15));
//
//        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
//        learnReqs.add(new RequireLevel(2));
//
//        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
//        useReqs.add(new RequireCurrentMP(15));
//
//        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
//        areas.add(new AngularInfluenceSet(new NorthDirection(), 2, new GrassTile()));
//
//        ArrayList<Effect> costs = new ArrayList<Effect>();
//        costs.add(new ModifyCurrentMana(-15));
//
//        return new Ability(effects, learnReqs, useReqs, areas, costs,"Angular Boon");
//    }
//    public static Ability generateSummonerRadialBoonAbility() {
//        ArrayList<Effect> effects = new ArrayList<Effect>();
//        effects.add(new ModifyCurrentLife(12));
//
//        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
//        learnReqs.add(new RequireLevel(3));
//
//        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
//        useReqs.add(new RequireCurrentMP(20));
//
//        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
//        areas.add(new RadialInfluenceSet(2, new GrassTile()));
//
//        ArrayList<Effect> costs = new ArrayList<Effect>();
//        costs.add(new ModifyCurrentMana(-20));
//
//        return new Ability(effects, learnReqs, useReqs, areas, costs,"Radial Boon");
//    }
    /* ---------- SNEAK ABILITIES ---------- */
    public static Ability generateSneakPickpocket() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyBooty(-10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequirePickpocket(10));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireCurrentMP(10));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new RadialInfluenceSet(1, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new ModifyCurrentMana(-10));
        costs.add(new ModifyBooty(10));

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Pickpocket");
    }
    public static Ability generateSneakCreep() {
        ArrayList<Effect> effects = new ArrayList<Effect>();

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireCreep(10));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new CreepEffect());

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Creep");
    }
    public static Ability generateSneakStopCreep() {
        ArrayList<Effect> effects = new ArrayList<Effect>();

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireCreep(10));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();

        ArrayList<Effect> costs = new ArrayList<Effect>();
        costs.add(new UncreepEffect());

        return new Ability(effects, learnReqs, useReqs, areas, costs,"Stop Creep");
    }
}
