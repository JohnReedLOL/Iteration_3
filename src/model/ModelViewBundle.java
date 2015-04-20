package model;

// @author comcc_000

import java.util.List;
import model.entity.ConversationNode;

import model.entity.ability.Ability;
import model.entity.avatar.Avatar;
import model.item.sackbound.SackboundItem;
import model.item.sackbound.equip.EquipItem;
import model.map.GameMap;
import model.map.GameWorld;
import model.map.location.Location;

public class ModelViewBundle {

    /*Properties*/

    private String currentKnownInfo;
    private static ModelViewBundle singleton;
    private UserSettings userSettings = new UserSettings();

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

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public Avatar getAvatar() {
        return Model.getAvatar();
    }

    public List<Ability> getLearnedAbilities() {
        return getAvatar().getLearnedAbilities();
    }

    public List<Ability> getUnlearnedAbilities() {
       return getAvatar().getUnlearnedAbilities();
    }

    public GameMap getMap() {
        // LOL - casting.
        return (GameMap) GameWorld.getCurrentMap();
    }

    public Location getAvatarLocation() {
        return getMap().getLocationByMapObject(getAvatar());
    }

    public ConversationNode getCurrentDialogue() {
        // TODO - IDFK until John tells us what's up.
        return null;
    }

    public String getCurrentKnownInfo() {
        return this.currentKnownInfo;
    }

    public List<SackboundItem> getInventory() {
        return getAvatar().getInventoryOwnership().getAllItems();
    }

    public List<EquipItem> getEquipment() {
        return getAvatar().getArmoryOwnership().getEquipment().getContents();
    }

    public List<SackboundItem> getMerchantInventory() {
        // TODO
        return null;
    }
    
    /**
     * List of all map objects that are allowed to be rendered.
     * If it's not in this list don't render it.
     * Don't worry about order of rendering for now.
     * @return 
     */
    public List<MapObject> getVisibleMapObjects(){
    	return getAvatar().getVisibleMapObjects();
    }
    
    /**
     * Works exactly like the old brightness table did
     * @author Matt <- yell at him if broken.
     * @return 
     */
    public int[][] getBrightnessTable(){
    	return getAvatar().getBrightnessTable();
    }

    public int getBooty() {
        return getAvatar().getBooty();
    }

    /*Setters*/

    public void setCurrentKnownInfo(String info) {
        this.currentKnownInfo = info;
    }

    /*Inner-classes*/

    /*Test Main Method*/

    

}
