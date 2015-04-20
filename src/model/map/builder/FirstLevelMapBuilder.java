package model.map.builder;

import model.armory.Armory;
import model.entity.avatar.Avatar;
import model.entity.behavior.movement.ClassicMovementBehavior;
import model.entity.npc.NPC;
import model.factories.ItemFactory;
import model.influence_set.InfluenceSet;
import model.inventory.Sack;
import model.item.interactive.InteractiveItem;
import model.item.obstacle.ObstacleItem;
import model.item.oneshot.OneShotItem;
import model.item.sackbound.LimitedConsumptionItem;
import model.item.sackbound.SackboundItem;
import model.item.sackbound.UnlimitedConsumptionItem;
import model.item.sackbound.equip.EquipItem;
import model.item.sackbound.equip.EquipItem.EquipSlot;
import model.item.sackbound.equip.WeaponItem;
import model.map.coordinate.HexCoordinate;
import model.map.location.*;
import utility.ScalingUtil;

import java.util.ArrayList;

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
                if (i < 3 || j < 3 )
                    tiles[i][j] = new BrickTile();
                else
                    tiles[i][j] = new GrassTile();
            }
        }

        tiles[1][3] = new MountainTile();
        tiles[2][2] = new WaterTile();
        tiles[3][3] = new WaterTile();
        tiles[4][4] = new WaterTile();
        tiles[4][1] = new WaterTile();
        tiles[5][5] = new WaterTile();

        tiles[1][1].createMapObjectAssociation(new ObstacleItem());
        tiles[1][2].createMapObjectAssociation(new NPC(new HexCoordinate(1, 1)));
        tiles[1][3].createMapObjectAssociation(ItemFactory.generate6SlicePizza());
        tiles[1][4].createMapObjectAssociation(ItemFactory.getTHEKey());
        tiles[1][5].createMapObjectAssociation(ItemFactory.generateElixirOneShotItem());
        tiles[1][6].createMapObjectAssociation(ItemFactory.generateElixirSackboundItem());
        tiles[1][7].createMapObjectAssociation(new UnlimitedConsumptionItem());
        tiles[1][8].createMapObjectAssociation(ItemFactory.generateLevel3ChainHood());
        tiles[1][9].createMapObjectAssociation(ItemFactory.generateLevel1Bow());
        tiles[2][9].createMapObjectAssociation(ItemFactory.generateTreasureChest());
        tiles[0][0].createMapObjectAssociation(ItemFactory.generateLevel3Shield());
        
        return tiles;
    }
}
