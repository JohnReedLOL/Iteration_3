package Load;

import model.entity.stats.SmasherStats;
import org.w3c.dom.Element;

public class SmasherStatsLoader {

    private SmasherStatsLoader(){
        super();
    }
    private static SmasherStatsLoader instance = null;
    public static SmasherStatsLoader getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new SmasherStatsLoader();
            return instance;
        }
    }


    public SmasherStats build(Element statsElement) throws LoadException {
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
            int oneHanded = Integer.parseInt(statsElement.getElementsByTagName("oneHanded").item(0).getTextContent());
            int twoHanded = Integer.parseInt(statsElement.getElementsByTagName("twoHanded").item(0).getTextContent());
            int brawl = Integer.parseInt(statsElement.getElementsByTagName("brawl").item(0).getTextContent());

            SmasherStats stats = new SmasherStats();
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
            stats.setOneHanded(oneHanded);
            stats.setTwoHanded(twoHanded);
            stats.setBrawl(brawl);

            return stats;
        } catch (Exception e) {
            throw new LoadException(e);
        }
    }
}
