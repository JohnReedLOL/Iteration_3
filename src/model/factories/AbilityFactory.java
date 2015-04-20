package model.factories;

import model.effect.Effect;
import model.effect.statseffect.ModifyCurrentLife;
import model.effect.statseffect.SmasherStatsEffect;
import model.effect.statseffect.StatsEffect;
import model.entity.ability.Ability;
import model.influence_set.InfluenceSet;
import model.influence_set.RadialInfluenceSet;
import model.map.location.GrassTile;
import model.map.location.Location;
import model.prerequisite.Prerequisite;
import model.prerequisite.RequireBrawl;
import model.prerequisite.RequireLevel;

import java.util.ArrayList;

public class AbilityFactory {
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

        return new Ability(effects, learnReqs, useReqs, areas, costs);
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

        return new Ability(effects, learnReqs, useReqs, areas, costs);
    }

    public static Ability generateSmasherBrawlAbility() {
        ArrayList<Effect> effects = new ArrayList<Effect>();
        effects.add(new ModifyCurrentLife(-10));

        ArrayList<Prerequisite> learnReqs = new ArrayList<Prerequisite>();
        learnReqs.add(new RequireLevel(1));

        ArrayList<Prerequisite> useReqs = new ArrayList<Prerequisite>();
        useReqs.add(new RequireBrawl(1));

        ArrayList<InfluenceSet> areas = new ArrayList<InfluenceSet>();
        areas.add(new RadialInfluenceSet(5, new GrassTile()));

        ArrayList<Effect> costs = new ArrayList<Effect>();

        return new Ability(effects, learnReqs, useReqs, areas, costs);
    }
}
