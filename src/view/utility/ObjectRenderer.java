package view.utility;

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

public interface ObjectRenderer {

	public void visit(Avatar avatar);

	public void visit(AIClassicEntity entity);

	public void visit(Mount mount);

	public void visit(NPC npc);

	public void visit(InteractiveItem interactiveItem);

	public void visit(ObstacleItem obstacleItem);

	public void visit(OneShotItem oneShotItem);

	public void visit(LimitedConsumptionItem limitedConsumptionItem);

	public void visit(UnlimitedConsumptionItem unlimitedConsumptionItem);

	public void visit(EquipItem equipItem);

	public void visit(WeaponItem weaponItem);
        
    public void visit(SackboundItem i);

	public void setX(int x);

	public void setY(int y);

	public void visit(SmasherStatsOwnership smasherStatsOwnership);
	
	public void visit(SneakStatsOwnership sneakStatsOwnership);
	
	public void visit(SummonerStatsOwnership summonerStatsOwnership);

	public void visit(StatsOwnership statsOwnership);

	public void setAvatarY(int avatarPosY);

	public void setAvatarX(int x);
}
