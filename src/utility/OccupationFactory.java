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
import model.map.GameWorld;
import model.map.coordinate.Coordinate2D;
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

        return smasher;
    }

    public static Avatar generateAvatarSneakOccupation() {
        Avatar sneak = new Avatar(new HexCoordinate(1, 1));

        return sneak;
    }

    public static Avatar generateAvatarSummonerOccupation() {
        Avatar summoner = new Avatar(new HexCoordinate(1, 1));

        return summoner;
    }

    public static NPC generateNpcSmasherOccupation() {
        NPC smasher = new NPC(new HexCoordinate(1, 1));

        return smasher;
    }

    public static NPC generateNpcSneakOccupation() {
        NPC sneak = new NPC(new HexCoordinate(1, 1));

        return sneak;
    }

    public static NPC generateNpcSummonerOccupation() {
        NPC summoner = new NPC(new HexCoordinate(1, 1));

        return summoner;
    }
}
