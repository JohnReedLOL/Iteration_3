package model.factories;

import java.util.ArrayList;

import model.effect.CreepEffect;
import model.effect.Effect;
import model.effect.PerformWeaponAttackEffect;
import model.effect.UncreepEffect;
import model.effect.statseffect.ModifyBooty;
import model.effect.statseffect.ModifyCurrentLife;
import model.effect.statseffect.ModifyCurrentMana;
import model.entity.ability.Ability;
import model.influence_set.InfluenceSet;
import model.influence_set.RadialInfluenceSet;
import model.map.location.GrassTile;
import model.prerequisite.Prerequisite;
import model.prerequisite.RequireBrawl;
import model.prerequisite.RequireCreep;
import model.prerequisite.RequireCurrentMP;
import model.prerequisite.RequireLevel;
import model.prerequisite.RequirePickpocket;

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
