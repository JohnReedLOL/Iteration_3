package Load;

import model.entity.stats.SummonerStats;
import org.w3c.dom.Element;

public class SummonerStatsLoader {

    private SummonerStatsLoader(){
        super();
    }
    private static SummonerStatsLoader instance = null;
    public static SummonerStatsLoader getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new SummonerStatsLoader();
            return instance;
        }
    }


    public SummonerStats build(Element statsElement) throws LoadException {
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

            int bane = Integer.parseInt(statsElement.getElementsByTagName("bane").item(0).getTextContent());
            int boon = Integer.parseInt(statsElement.getElementsByTagName("boon").item(0).getTextContent());
            int enchantment = Integer.parseInt(statsElement.getElementsByTagName("enchantment").item(0).getTextContent());
            int staff = Integer.parseInt(statsElement.getElementsByTagName("staff").item(0).getTextContent());

            SummonerStats stats = new SummonerStats();
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
            stats.setBane(bane);
            stats.setBoon(boon);
            stats.setEnchantment(enchantment);
            stats.setStaff(staff);

            return stats;
        } catch (Exception e) {
            throw new LoadException(e);
        }
    }
}

