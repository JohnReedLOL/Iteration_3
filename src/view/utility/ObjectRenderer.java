package view.utility;

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

public interface ObjectRenderer {

	public void visit(Avatar avatar);

	public void visit(AIClassicEntity entity);

	public void visit(NPC npc);

	public void visit(InteractiveItem interactiveItem);

	public void visit(ObstacleItem obstacleItem);

	public void visit(OneShotItem oneShotItem);

	public void visit(LimitedConsumptionItem limitedConsumptionItem);

	public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem);

	public void visit(EquipItem equipItem);

	public void visit(WeaponItem weaponItem);

	public void setX(int x);

	public void setY(int y);
}
