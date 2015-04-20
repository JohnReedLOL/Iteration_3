package model;

// @author comcc_000

import java.util.List;

import model.entity.ConversationNodeWithChildren;
import model.entity.ability.Ability;
import model.entity.avatar.Avatar;
import model.item.sackbound.SackboundItem;
import model.item.sackbound.equip.EquipItem;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.location.Location;

public class ModelViewBundle {

    /*Properties*/

    private static ModelViewBundle singleton;
    private static UserSettings userSettings = new UserSettings();

    /*Constructors*/

    private ModelViewBundle() { }

    /*Methods*/

    /*Get-Sets*/

    public static ModelViewBundle getInstance() {
        if (singleton == null) {
            singleton = new ModelViewBundle();
        }

        return singleton;
    }

    public static UserSettings getUserSettings() {
        return userSettings;
    }

    public static Avatar getAvatar() {
        return Model.getAvatar();
    }

    public static List<Ability> getLearnedAbilities() {
        return getAvatar().getLearnedAbilities();
    }

    public static List<Ability> getUnlearnedAbilities() {
       return getAvatar().getUnlearnedAbilities();
    }

    public static GameMap getMap() {
        // LOL - casting.
     return (GameMap) GameWorld.getCurrentMap();
    }

    public static Location getAvatarLocation() {
        return getMap().getLocationByMapObject(getAvatar());
    }

    public static ConversationNodeWithChildren getCurrentDialogue() {
        // TODO - IDFK until John tells us what's up.
        return null;
    }

    public static List<SackboundItem> getInventory() {
        return getAvatar().getInventoryOwnership().getAllItems();
    }

    public static List<EquipItem> getEquipment() {
        return getAvatar().getArmoryOwnership().getEquipment().getContents();
    }

    public static List<SackboundItem> getMerchantInventory() {
        // TODO
        return null;
    }
    
    public static List<MapObject> getVisibleMapObjects(){
    	return getAvatar().getVisibleMapObjects();
    }
    
    public static int[][] getBrightnessTable(){
    	return getAvatar().getBrightnessTable();
    }

    public static int getBooty() {
        getAvatar().getBooty();
        return 0;
    }

    /*Inner-classes*/

    /*Test Main Method*/

    

}
