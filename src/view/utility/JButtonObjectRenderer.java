/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.utility;

import application.Application;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import utility.ImageUtil;
import model.entity.ai.AIClassicEntity;
import model.entity.avatar.Avatar;
import model.entity.npc.NPC;
import model.entity.npc.mount.Mount;
import model.entity.stats.SmasherStatsOwnership;
import model.entity.stats.SneakStatsOwnership;
import model.entity.stats.StatsOwnership;
import model.entity.stats.SummonerStatsOwnership;
import model.item.interactive.InteractiveItem;
import model.item.obstacle.ObstacleItem;
import model.item.oneshot.OneShotItem;
import model.item.sackbound.LimitedConsumptionItem;
import model.item.sackbound.SackboundItem;
import model.item.sackbound.UnlimitedConsumptionItem;
import model.item.sackbound.equip.EquipItem;
import model.item.sackbound.equip.WeaponItem;

/**
 * This class takes in a JButton using setButtonForMeToRenderTo and then takes
 * in an object via the visit method and then renders that object to that
 * JButton.
 *
 * @author johnmichaelreed2
 */
public class JButtonObjectRenderer implements ObjectRenderer {

    private JButton button_to_render_on_;

    private static BufferedImage SACKBOUND_ITEM;
    private static BufferedImage NPC_S;
    private static BufferedImage INT_ITEM;
    private static BufferedImage OBS_ITEM;
    private static BufferedImage ONE_SHOT_ITEM;
    private static BufferedImage LC_ITEM;
    private static BufferedImage UC_ITEM;
    private static BufferedImage EQUIP;
    private static BufferedImage WEAPON;

    public JButtonObjectRenderer() {
    	initializeImages();
    }
    private void initializeImages() {

		if (NPC_S == null) {
			NPC_S = ImageUtil.getImage("resources/png/dave_S.png");
		}

		if (INT_ITEM == null) {
			INT_ITEM = ImageUtil
					.getImage("resources/png/Locked_Treasure_Box.png");
		}

		if (OBS_ITEM == null) {
			OBS_ITEM = ImageUtil.getImage("resources/png/ObstacleItem.png");
		}

		if (ONE_SHOT_ITEM == null) {
			ONE_SHOT_ITEM = ImageUtil
					.getImage("resources/png/Health_Potion.png");
		}

		if (LC_ITEM == null) {
			LC_ITEM = ImageUtil.getImage("resources/png/Health_Potion.png");
		}

		if (UC_ITEM == null) {
			UC_ITEM = ImageUtil.getImage("resources/png/Mana_Potion.png");
		}

		if (EQUIP == null) {
			EQUIP = ImageUtil.getImage("resources/png/Helmet.png");
		}

		if (WEAPON == null) {
			WEAPON = ImageUtil.getImage("resources/png/Matts_sword_PNG.png");
		}
		if (SACKBOUND_ITEM == null) {
			SACKBOUND_ITEM = ImageUtil.getImage("resources/png/TextSackBoundItem.png");
		}
	}
    
    public void setButtonForMeToRenderTo(JButton to_render_on) {
        button_to_render_on_ = to_render_on;
    }

    public JButton getButtonThatIAmRenderingOn() {
        return button_to_render_on_;
    }

    final String temp_file_name = Object_To_File_Name_Mapping.imageNotAvailible_;

    @Override
    public void visit(Avatar avatar) {
//        Application.check(button_to_render_on_ != null);
//        button_to_render_on_.setIcon(new ImageIcon(grass_));
    }

    @Override
    public void visit(AIClassicEntity entity) {
//        Application.check(button_to_render_on_ != null);
//        button_to_render_on_.setIcon(new ImageIcon(grass_));
    }

    @Override
    public void visit(Mount mount) {
//        Application.check(button_to_render_on_ != null);
//        button_to_render_on_.setIcon(new ImageIcon(grass_));
    }

    @Override
    public void visit(NPC npc) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(NPC_S));
    }

    @Override
    public void visit(InteractiveItem interactiveItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(INT_ITEM));
    }

    @Override
    public void visit(ObstacleItem obstacleItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(OBS_ITEM));
    }

    @Override
    public void visit(OneShotItem oneShotItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(ONE_SHOT_ITEM));
    }

    @Override
    public void visit(LimitedConsumptionItem limitedConsumptionItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(LC_ITEM));
    }

    @Override
    public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(UC_ITEM));
    }

    @Override
    public void visit(EquipItem equipItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(EQUIP));
    }

    @Override
    public void visit(WeaponItem weaponItem) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(WEAPON));
    }

    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(SackboundItem i) {
        Application.check(button_to_render_on_ != null);
        button_to_render_on_.setIcon(new ImageIcon(SACKBOUND_ITEM));
    }

    @Override
    public void visit(SmasherStatsOwnership smasherStatsOwnership) {
		// TODO Auto-generated method stub

    }

    @Override
    public void visit(SneakStatsOwnership sneakStatsOwnership) {
		// TODO Auto-generated method stub

    }

    @Override
    public void visit(SummonerStatsOwnership summonerStatsOwnership) {
		// TODO Auto-generated method stub

    }

    @Override
    public void visit(StatsOwnership statsOwnership) {
		// TODO Auto-generated method stub

    }

    @Override
    public void setAvatarX(int x) {
		// TODO Auto-generated method stub

    }

    @Override
    public void setAvatarY(int y) {
		// TODO Auto-generated method stub

    }

}
