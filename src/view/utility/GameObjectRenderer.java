package view.utility;

import application.Application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import model.entity.npc.Merchant;
import utility.ImageUtil;
import model.MapObject;
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

public class GameObjectRenderer extends GameScreenRenderer implements
		ObjectRenderer {

	private List<MapObject> mapObjects;

	private static BufferedImage avatarN;
	private static BufferedImage avatarS;
	private static BufferedImage avatarNW;
	private static BufferedImage avatarNE;
	private static BufferedImage avatarSW;
	private static BufferedImage avatarSE;

	private static BufferedImage vespaN;
	private static BufferedImage vespaS;
	private static BufferedImage vespaNW;
	private static BufferedImage vespaNE;
	private static BufferedImage vespaSW;
	private static BufferedImage vespaSE;

	private static BufferedImage NPC_S;
	private static BufferedImage INT_ITEM;
	private static BufferedImage OBS_ITEM;
	private static BufferedImage ONE_SHOT_ITEM;
	private static BufferedImage LC_ITEM;
	private static BufferedImage UC_ITEM;
	private static BufferedImage EQUIP;
	private static BufferedImage WEAPON;

	private static BufferedImage MERCHANT;

	public GameObjectRenderer(Graphics g, List<MapObject> mapObjects) {
		super(g);
		this.startx = 0;
		this.starty = 0;
		this.mapObjects = mapObjects;
		initializeImages();
	}

	public GameObjectRenderer(Graphics g, int startx, int starty,
			List<MapObject> mapObjects) {
		super(g);
		this.startx = startx;
		this.starty = starty;
		this.mapObjects = mapObjects;
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

		if (vespaN == null) {
			vespaN = ImageUtil.getImage("resources/png/vespa_N.png");
		}

		if (vespaS == null) {
			vespaS = ImageUtil.getImage("resources/png/vespa_S.png");
		}

		if (vespaNW == null) {
			vespaNW = ImageUtil.getImage("resources/png/vespa_NW.png");
		}

		if (vespaNE == null) {
			vespaNE = ImageUtil.getImage("resources/png/vespa_NE.png");
		}

		if (vespaSW == null) {
			vespaSW = ImageUtil.getImage("resources/png/vespa_SW.png");
		}

		if (vespaSE == null) {
			vespaSE = ImageUtil.getImage("resources/png/vespa_SE.png");
		}

		if (MERCHANT == null) {
			MERCHANT = ImageUtil.getImage("resources/png/merchant.png");
		}
	}

	private void initializeAvatarImages(String occupation) {

		if (avatarN == null) {
			avatarN = ImageUtil.getImage("resources/png/" + occupation
					+ "_N.png");

		}
		if (avatarS == null) {
			avatarS = ImageUtil.getImage("resources/png/" + occupation
					+ "_S.png");

		}
		if (avatarNW == null) {
			avatarNW = ImageUtil.getImage("resources/png/" + occupation
					+ "_NW.png");
		}
		if (avatarNE == null) {
			avatarNE = ImageUtil.getImage("resources/png/" + occupation
					+ "_NE.png");

		}
		if (avatarSW == null) {
			avatarSW = ImageUtil.getImage("resources/png/" + occupation
					+ "_SW.png");

		}
		if (avatarSE == null) {
			avatarSE = ImageUtil.getImage("resources/png/" + occupation
					+ "_SE.png");
		}

	}

	public void visit(Avatar avatar) {
		String facing = avatar.getDirection().toString();
		drawAvatar(facing);
	}

	@Override
	public void visit(SmasherStatsOwnership smasherStatsOwnership) {
		initializeAvatarImages("smasher");
	}

	@Override
	public void visit(SneakStatsOwnership sneakStatsOwnership) {
		initializeAvatarImages("sneak");
	}

	@Override
	public void visit(SummonerStatsOwnership summonerStatsOwnership) {
		initializeAvatarImages("summoner");
	}

	private void drawAvatar(String facing) {
		switch (facing) {
		case "N":
			drawImage(avatarN);
			break;
		case "NE":
			drawImage(avatarNE);
			break;
		case "NW":
			drawImage(avatarNW);
			break;
		case "S":
			drawImage(avatarS);
			break;
		case "SE":
			drawImage(avatarSE);
			break;
		case "SW":
			drawImage(avatarSW);
			break;
		default:
			drawImage(avatarS);
			break;
		}
	}

	private void drawMount(String facing) {
		switch (facing) {
		case "N":
			drawImage(vespaN);
			break;
		case "NE":
			drawImage(vespaNE);
			break;
		case "NW":
			drawImage(vespaNW);
			break;
		case "S":
			drawImage(vespaS);
			break;
		case "SE":
			drawImage(vespaSE);
			break;
		case "SW":
			drawImage(vespaSW);
			break;
		default:
			drawImage(vespaS);
			break;
		}
	}

	private void drawImage(BufferedImage img) {
		scaleXandY(x, y);
		g.drawImage(img, drawx, drawy, 100, 100, null);
	}

	public void visit(AIClassicEntity entity) {
		scaleXandY(x, y);
		g.setColor(Color.MAGENTA);
		g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
				HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		g.setColor(Color.BLACK);
		g.drawString("AI ENTITY", drawx + HEXAGON_SIZE / 4, drawy
				+ HEXAGON_SIZE / 4);
	}

	public void visit(Mount mount) {
		scaleXandY(x, y);
		String facing = mount.getDirection().toString();
		drawMount(facing);
	}

	@Override
	public void visit(NPC npc) {
		drawImage(MERCHANT);
	}

//	public void visit(NPC npc) {
//		// if (mapObjects.contains(npc)) {
//		// scaleXandY(x, y);
//		// g.setColor(Color.RED);
//		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
//		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
//		// g.setColor(Color.BLACK);
//		// g.drawString("NPC", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
//		// / 4);
//		// }
//
//		drawImage(NPC_S);
//
//	}

	public void visit(InteractiveItem interactiveItem) {
		// if (mapObjects.contains(interactiveItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.CYAN);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.drawString("IITEM", drawx + HEXAGON_SIZE / 4, drawy
		// + HEXAGON_SIZE / 4);
		// }
		drawImage(INT_ITEM);
	}

	public void visit(ObstacleItem obstacleItem) {
		// if (mapObjects.contains(obstacleItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.MAGENTA);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.drawString("OBITEM", drawx + HEXAGON_SIZE / 4, drawy
		// + HEXAGON_SIZE / 4);
		// }

		drawImage(OBS_ITEM);
	}

	public void visit(Merchant merchant) {
		// if (mapObjects.contains(obstacleItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.MAGENTA);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.drawString("OBITEM", drawx + HEXAGON_SIZE / 4, drawy
		// + HEXAGON_SIZE / 4);
		// }

		drawImage(MERCHANT);
	}

	public void visit(OneShotItem oneShotItem) {
		// if (mapObjects.contains(oneShotItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.ORANGE);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.drawString("OSITEM", drawx + HEXAGON_SIZE / 4, drawy
		// + HEXAGON_SIZE / 4);
		// }

		drawImage(ONE_SHOT_ITEM);
	}

	public void visit(LimitedConsumptionItem limitedConsumptionItem) {
		// if (mapObjects.contains(limitedConsumptionItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.PINK);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.drawString("LCITEM", drawx + HEXAGON_SIZE / 4, drawy
		// + HEXAGON_SIZE / 4);
		// }
		drawImage(LC_ITEM);
	}

	public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem) {
		// if (mapObjects.contains(unlimitedConsumptionItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.WHITE);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.drawString("UCITEM", drawx + HEXAGON_SIZE / 4, drawy
		// + HEXAGON_SIZE / 4);
		// }

		drawImage(UC_ITEM);
	}

	public void visit(EquipItem equipItem) {
		// if (mapObjects.contains(equipItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.WHITE);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.BLACK);
		// g.fillRect(drawx + HEXAGON_SIZE / 8 * 3, drawy + HEXAGON_SIZE / 8
		// * 3, HEXAGON_SIZE / 4, HEXAGON_SIZE / 4);
		// g.setColor(Color.BLACK);
		// g.drawString("E", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
		// / 4);
		// }
		drawImage(EQUIP);
	}

	public void visit(WeaponItem weaponItem) {
		// if (mapObjects.contains(weaponItem)) {
		// scaleXandY(x, y);
		// g.setColor(Color.WHITE);
		// g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
		// HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		// g.setColor(Color.RED);
		// g.fillRect(drawx + HEXAGON_SIZE / 8 * 3, drawy + HEXAGON_SIZE / 8
		// * 3, HEXAGON_SIZE / 4, HEXAGON_SIZE / 4);
		// g.setColor(Color.BLACK);
		// g.drawString("W", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
		// / 4);
		// }
		drawImage(WEAPON);
	}

	@Override
	public void visit(SackboundItem i) {
		// Application.print("Not yet supported yet");
	}

	/**
	 * not used
	 */
	@Override
	public void visit(StatsOwnership statsOwnership) {
		// TODO Auto-generated method stub
	}

}
