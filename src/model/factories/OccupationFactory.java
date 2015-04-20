package model.factories;

import model.entity.avatar.Avatar;
import model.entity.npc.NPC;
import model.entity.stats.SmasherStatsOwnership;
import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.SummonerStatsOwnership;
import model.map.coordinate.HexCoordinate;

public class OccupationFactory {
    /**
     * PROPERTIES
     */
    private static OccupationFactory singleton = new OccupationFactory();

    /**
     * CONSTRUCTORS
     */

    private OccupationFactory() { }

    /**
     * GETTERS
     */

    public static OccupationFactory getInstance() {
        return singleton;
    }

    /**
     * IMPLEMENTATIONS
     */

    public static Avatar generateAvatarSmasherOccupation() {
        // TODO: Add default location in the GameMap.
        Avatar smasher = new Avatar(new HexCoordinate(1, 1));
        smasher.setStatsOwnership(new SmasherStatsOwnership(smasher));
        smasher.addAbility(AbilityFactory.generateBindWoundsAbility());
        smasher.addAbility(AbilityFactory.generateObservationAbility());
        smasher.addAbility(AbilityFactory.generateBasicAttackAbility());
        smasher.addAbility(AbilityFactory.generateSmasherRageBrawlAbility());
        smasher.addAbility(AbilityFactory.generateSmasherHulkSmashBrawlAbility());

        return smasher;
    }

    public static Avatar generateAvatarSneakOccupation() {
        Avatar sneak = new Avatar(new HexCoordinate(1, 1));
        sneak.setStatsOwnership(new SneakStatsOwnership(sneak));
        sneak.addAbility(AbilityFactory.generateObservationAbility());
        sneak.addAbility(AbilityFactory.generateBindWoundsAbility());
        sneak.addAbility(AbilityFactory.generateBasicAttackAbility());
        sneak.addAbility(AbilityFactory.generateSneakCreep());
        sneak.addAbility(AbilityFactory.generateSneakPickpocket());
        sneak.addAbility(AbilityFactory.generateSneakStopCreep());

        return sneak;
    }

    public static Avatar generateAvatarSummonerOccupation() {
        Avatar summoner = new Avatar(new HexCoordinate(1, 1));
        summoner.setStatsOwnership(new SummonerStatsOwnership(summoner));
        summoner.addAbility(AbilityFactory.generateObservationAbility());
        summoner.addAbility(AbilityFactory.generateBindWoundsAbility());
        // TODO: Add all the Summoner abilities.

        return summoner;
    }

    public static NPC generateNpcSmasherOccupation() {
        NPC smasher = new NPC(new HexCoordinate(1, 1));
        smasher.setStatsOwnership(new SmasherStatsOwnership(smasher));

        return smasher;
    }

    public static NPC generateNpcSneakOccupation() {
        NPC sneak = new NPC(new HexCoordinate(1, 1));
        sneak.setStatsOwnership(new SneakStatsOwnership(sneak));

        return sneak;
    }

    public static NPC generateNpcSummonerOccupation() {
        NPC summoner = new NPC(new HexCoordinate(1, 1));
        summoner.setStatsOwnership(new SummonerStatsOwnership(summoner));

        return summoner;
    }
}
