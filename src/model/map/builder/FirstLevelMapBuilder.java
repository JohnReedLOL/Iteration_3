package model.map.builder;

import model.armory.Armory;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.npc.NPC;
import model.entity.occupation.SneakOccupation;
import model.inventory.Sack;
import model.item.interactive.InteractiveItem;
import model.item.obstacle.ObstacleItem;
import model.item.oneshot.OneShotItem;
import model.item.sackbound.LimitedConsumptionItem;
import model.item.sackbound.UnlimitedConsumptionItem;
import model.item.sackbound.equip.EquipItem;
import model.item.sackbound.equip.EquipItem.EquipSlot;
import model.item.sackbound.equip.WeaponItem;
import model.map.location.GrassTile;
import model.map.location.MountainTerrain;
import model.map.location.Tile;
import model.map.location.WaterTile;
import utility.ScalingUtil;

/**
 * Created by Troy on 4/17/2015.
 */
public class FirstLevelMapBuilder extends MapBuilder {
    @Override
    public Tile[][] generateMap() {
        return generateMap(ScalingUtil.MAP_DEFAULT_HEIGHT, ScalingUtil.MAP_DEFAULT_WIDTH);
    }

    public Tile[][] generateMap(int height, int width) {
        //TODO: MAKE THIS DO SOMETHING USEFUL
        Tile[][] tiles = new Tile[height][width];
        for ( int i = 0; i < tiles.length; ++i ) {
            for ( int j = 0; j < tiles[0].length; ++j ) {
                tiles[i][j] = new GrassTile();
            }
        }

        tiles[1][3] = new MountainTerrain();
        tiles[2][2] = new WaterTile();
        tiles[3][3] = new WaterTile();
        tiles[4][4] = new WaterTile();
        tiles[4][1] = new WaterTile();
        tiles[5][5] = new WaterTile();

        tiles[1][1].getMapObjects().add(new ObstacleItem());
        tiles[1][2].getMapObjects().add(new NPC(new Armory(),new Sack(), new SneakOccupation(),new ClassicMovementBehavior()));
        tiles[1][3].getMapObjects().add(new Avatar(new Armory(),new Sack(), new SneakOccupation(),new ClassicMovementBehavior()));
        tiles[1][4].getMapObjects().add(new InteractiveItem());
        tiles[1][5].getMapObjects().add(new OneShotItem());
        tiles[1][6].getMapObjects().add(new LimitedConsumptionItem());
        tiles[1][7].getMapObjects().add(new UnlimitedConsumptionItem());
        tiles[1][8].getMapObjects().add(new EquipItem(EquipSlot.HEAD));
        tiles[1][9].getMapObjects().add(new WeaponItem());
        
        return tiles;
    }
}
