package Load;

import model.entity.stats.SneakStats;
import org.w3c.dom.Element;

public class SneakStatsLoader {

    private SneakStatsLoader(){
        super();
    }
    private static SneakStatsLoader instance = null;
    public static SneakStatsLoader getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new SneakStatsLoader();
            return instance;
        }
    }


    public SneakStats build(Element statsElement) throws LoadException {
        try {
            int currentLife = Integer.parseInt(statsElement.getElementsByTagName("currentLife").item(0).getTextContent());
            int currentMana = Integer.parseInt(statsElement.getElementsByTagName("currentMana").item(0).getTextContent());
            int strength = Integer.parseInt(statsElement.getElementsByTagName("strength").item(0).getTextContent());
            int hardiness = Integer.parseInt(statsElement.getElementsByTagName("hardiness").item(0).getTextContent());
            int intellect = Integer.parseInt(statsElement.getElementsByTagName("intellect").item(0).getTextContent());
            int experience = Integer.parseInt(statsElement.getElementsByTagName("experience").item(0).getTextContent());
            int movement = Integer.parseInt(statsElement.getElementsByTagName("movement").item(0).getTextContent());
            int agility = Integer.parseInt(statsElement.getElementsByTagName("agility").item(0).getTextContent());
            int bindWounds = Integer.parseInt(statsElement.getElementsByTagName("bindWounds").item(0).getTextContent());
            int observation = Integer.parseInt(statsElement.getElementsByTagName("observation").item(0).getTextContent());
            int bargain = Integer.parseInt(statsElement.getElementsByTagName("bargain").item(0).getTextContent());
            int weaponModifier = Integer.parseInt(statsElement.getElementsByTagName("weaponModifier").item(0).getTextContent());
            int armorModifier = Integer.parseInt(statsElement.getElementsByTagName("armorModifier").item(0).getTextContent());
            int pickpocket = Integer.parseInt(statsElement.getElementsByTagName("pickpocket").item(0).getTextContent());
            int trapping = Integer.parseInt(statsElement.getElementsByTagName("trapping").item(0).getTextContent());
            int creep = Integer.parseInt(statsElement.getElementsByTagName("creep").item(0).getTextContent());
            int rangedWeapon = Integer.parseInt(statsElement.getElementsByTagName("rangedWeapon").item(0).getTextContent());

            SneakStats stats = new SneakStats();
            stats.setCurrentLife(currentLife);
            stats.setCurrentMana(currentMana);
            stats.setStrength(strength);
            stats.setHardiness(hardiness);
            stats.setIntellect(intellect);
            stats.setExperience(experience);
            stats.setMovement(movement);
            stats.setAgility(agility);
            stats.setBindWounds(bindWounds);
            stats.setObservation(observation);
            stats.setBargain(bargain);
            stats.setWeaponModifier(weaponModifier);
            stats.setArmorModifier(armorModifier);
            stats.setPickpocket(pickpocket);
            stats.setCreep(creep);
            stats.setTrapping(trapping);
            stats.setRangedWeapon(rangedWeapon);

            return stats;
        } catch (Exception e) {
            throw new LoadException(e);
        }
    }
}

