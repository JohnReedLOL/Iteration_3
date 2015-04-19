package view.utility;

import java.awt.Color;
import java.awt.Graphics;

import model.entity.avatar.Avatar;
import model.entity.npc.NPC;
import model.item.interactive.InteractiveItem;
import model.item.obstacle.ObstacleItem;
import model.item.oneshot.OneShotItem;
import model.item.sackbound.LimitedConsumptionItem;
import model.item.sackbound.UnlimitedConsumptionItem;
import model.item.sackbound.equip.EquipItem;
import model.item.sackbound.equip.WeaponItem;

public class MiniGameObjectRenderer extends MiniRenderer implements ObjectRenderer {

	public MiniGameObjectRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
	}
	public void visit(Avatar avatar) {
		scaleXandY(x, y);
		g.setColor(Color.YELLOW);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(NPC npc) {
		scaleXandY(x, y);
		g.setColor(Color.RED);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(InteractiveItem interactiveItem) {
		scaleXandY(x, y);
		g.setColor(Color.CYAN);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(ObstacleItem obstacleItem) {
		scaleXandY(x, y);
		g.setColor(Color.MAGENTA);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(OneShotItem oneShotItem) {
		scaleXandY(x, y);
		g.setColor(Color.ORANGE);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(LimitedConsumptionItem limitedConsumptionItem) {
		scaleXandY(x, y);
		g.setColor(Color.PINK);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem) {
		scaleXandY(x, y);
		g.setColor(Color.WHITE);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
	}

	public void visit(EquipItem equipItem) {
		scaleXandY(x, y);
		g.setColor(Color.WHITE);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
		g.setColor(Color.BLACK);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/8*3, drawy+SIZE_OF_MAP_PIXEL/8*3, SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/4);
	}
	
	public void visit(WeaponItem weaponItem) {
		scaleXandY(x, y);
		g.setColor(Color.WHITE);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/4, drawy+SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/2, SIZE_OF_MAP_PIXEL/2);
		g.setColor(Color.RED);
		g.fillRect(drawx+SIZE_OF_MAP_PIXEL/8*3, drawy+SIZE_OF_MAP_PIXEL/8*3, SIZE_OF_MAP_PIXEL/4, SIZE_OF_MAP_PIXEL/4);
	}

}
