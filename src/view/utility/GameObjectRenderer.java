package view.utility;

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

public class GameObjectRenderer extends GameScreenRenderer implements ObjectRenderer{

	
	public GameObjectRenderer(Graphics g, int startx, int starty) {
		super(g);
		this.startx = startx;
		this.starty = starty;
	}

	public void visit(Avatar avatar) {
		// TODO Auto-generated method stub
		
	}

	public void visit(NPC npc) {
		// TODO Auto-generated method stub
		
	}

	public void visit(InteractiveItem interactiveItem) {
		// TODO Auto-generated method stub
		
	}

	public void visit(ObstacleItem obstacleItem) {
		// TODO Auto-generated method stub
		
	}

	public void visit(OneShotItem oneShotItem) {
		// TODO Auto-generated method stub
		
	}

	public void visit(LimitedConsumptionItem limitedConsumptionItem) {
		// TODO Auto-generated method stub
		
	}

	public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem) {
		// TODO Auto-generated method stub
		
	}

	public void visit(EquipItem equipItem) {
		// TODO Auto-generated method stub
		
	}
	
	public void visit(WeaponItem weaponItem) {
		// TODO Auto-generated method stub
		
	}
	
	
}
