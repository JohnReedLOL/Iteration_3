package view.utility;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import model.MapObject;
import model.entity.ai.AIClassicEntity;
import model.entity.avatar.Avatar;
import model.entity.npc.NPC;
import model.item.interactive.InteractiveItem;
import model.item.obstacle.ObstacleItem;
import model.item.oneshot.OneShotItem;
import model.item.sackbound.LimitedConsumptionItem;
import model.item.sackbound.UnlimitedConsumptionItem;
import model.item.sackbound.equip.EquipItem;
import model.item.sackbound.equip.WeaponItem;

public class GameObjectRenderer extends GameScreenRenderer implements
		ObjectRenderer {

	private List<MapObject> mapObjects;

	public GameObjectRenderer(Graphics g, List<MapObject> mapObjects) {
		super(g);
		this.startx = 0;
		this.starty = 0;
		this.mapObjects = mapObjects;
	}

	public GameObjectRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
	}

	public void visit(Avatar avatar) {
		scaleXandY(x, y);
		g.setColor(Color.YELLOW);
		g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
				HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		g.setColor(Color.BLACK);
		g.drawString("AVATAR", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
				/ 4);
	}

	public void visit(AIClassicEntity entity) {
		scaleXandY(x, y);
		g.setColor(Color.MAGENTA);
		g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
				HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
		g.setColor(Color.BLACK);
		g.drawString("AI ENTITY", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
				/ 4);
	}

	public void visit(NPC npc) {
		if (mapObjects.contains(npc)) {
			scaleXandY(x, y);
			g.setColor(Color.RED);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.drawString("NPC", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
					/ 4);
		}
	}

	public void visit(InteractiveItem interactiveItem) {
		if (mapObjects.contains(interactiveItem)) {
			scaleXandY(x, y);
			g.setColor(Color.CYAN);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.drawString("IITEM", drawx + HEXAGON_SIZE / 4, drawy
					+ HEXAGON_SIZE / 4);
		}
	}

	public void visit(ObstacleItem obstacleItem) {
		if (mapObjects.contains(obstacleItem)) {
			scaleXandY(x, y);
			g.setColor(Color.MAGENTA);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.drawString("OBITEM", drawx + HEXAGON_SIZE / 4, drawy
					+ HEXAGON_SIZE / 4);
		}
	}

	public void visit(OneShotItem oneShotItem) {
		if (mapObjects.contains(oneShotItem)) {
			scaleXandY(x, y);
			g.setColor(Color.ORANGE);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.drawString("OSITEM", drawx + HEXAGON_SIZE / 4, drawy
					+ HEXAGON_SIZE / 4);
		}
	}

	public void visit(LimitedConsumptionItem limitedConsumptionItem) {
		if (mapObjects.contains(limitedConsumptionItem)) {
			scaleXandY(x, y);
			g.setColor(Color.PINK);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.drawString("LCITEM", drawx + HEXAGON_SIZE / 4, drawy
					+ HEXAGON_SIZE / 4);
		}
	}

	public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem) {
		if (mapObjects.contains(unlimitedConsumptionItem)) {
			scaleXandY(x, y);
			g.setColor(Color.WHITE);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.drawString("UCITEM", drawx + HEXAGON_SIZE / 4, drawy
					+ HEXAGON_SIZE / 4);
		}
	}

	public void visit(EquipItem equipItem) {
		if (mapObjects.contains(equipItem)) {
			scaleXandY(x, y);
			g.setColor(Color.WHITE);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.BLACK);
			g.fillRect(drawx + HEXAGON_SIZE / 8 * 3, drawy + HEXAGON_SIZE / 8
					* 3, HEXAGON_SIZE / 4, HEXAGON_SIZE / 4);
			g.setColor(Color.BLACK);
			g.drawString("E", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
					/ 4);
		}
	}

	public void visit(WeaponItem weaponItem) {
		if (mapObjects.contains(weaponItem)) {
			scaleXandY(x, y);
			g.setColor(Color.WHITE);
			g.fillRect(drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE / 4,
					HEXAGON_SIZE / 2, HEXAGON_SIZE / 2);
			g.setColor(Color.RED);
			g.fillRect(drawx + HEXAGON_SIZE / 8 * 3, drawy + HEXAGON_SIZE / 8
					* 3, HEXAGON_SIZE / 4, HEXAGON_SIZE / 4);
			g.setColor(Color.BLACK);
			g.drawString("W", drawx + HEXAGON_SIZE / 4, drawy + HEXAGON_SIZE
					/ 4);
		}
	}

}
