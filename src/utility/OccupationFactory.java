package utility;

import model.armory.Armory;
import model.entity.Entity;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.npc.NPC;
import model.entity.stats.SmasherStatsOwnership;
import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.SummonerStatsOwnership;
import model.inventory.Sack;

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
        Avatar smasher = new Avatar(new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new SmasherStatsOwnership(null));

        return smasher;
    }

    public static Avatar generateAvatarSneakOccupation() {
        Avatar sneak = new Avatar(new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new SneakStatsOwnership(null));

        return sneak;
    }

    public static Avatar generateAvatarSummonerOccupation() {
        Avatar summoner = new Avatar(new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new SummonerStatsOwnership(null));

        return summoner;
    }

    public static NPC generateNpcSmasherOccupation() {
        NPC smasher = new NPC(new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new SmasherStatsOwnership(null));

        return smasher;
    }

    public static NPC generateNpcSneakOccupation() {
        NPC sneak = new NPC(new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new SneakStatsOwnership(null));

        return sneak;
    }

    public static NPC generateNpcSummonerOccupation() {
        NPC summoner = new NPC(new Armory(), new Sack(), ClassicMovementBehavior.getInstance(), new SummonerStatsOwnership(null));

        return summoner;
    }
}
