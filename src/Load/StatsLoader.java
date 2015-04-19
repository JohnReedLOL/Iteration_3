package Load;

import model.entity.stats.Stats;
import Load.LoadException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class StatsLoader {

    private static StatsLoader instance = null;
    public static StatsLoader getInstance() {
        if(instance != null) {
           return instance;
        }
        else {
           instance = new StatsLoader();
            return instance;
        }
    }


    public StatsLoader(){}
    public Stats build(Element statsElement) throws LoadException {
        try {
            int currentLife = Integer.parseInt( statsElement.getElementsByTagName("currentLife").item(0).getTextContent() );
            int currentMana = Integer.parseInt( statsElement.getElementsByTagName("currentMana").item(0).getTextContent() );
            int strength = Integer.parseInt( statsElement.getElementsByTagName("strength").item(0).getTextContent() );
            int hardiness = Integer.parseInt( statsElement.getElementsByTagName("hardiness").item(0).getTextContent() );
            int intellect = Integer.parseInt( statsElement.getElementsByTagName("intellect").item(0).getTextContent() );
            int experience = Integer.parseInt( statsElement.getElementsByTagName("experience").item(0).getTextContent() );
            int movement = Integer.parseInt( statsElement.getElementsByTagName("movement").item(0).getTextContent() );
            int agility = Integer.parseInt( statsElement.getElementsByTagName("agility").item(0).getTextContent() );
            int bindWounds = Integer.parseInt( statsElement.getElementsByTagName("bindWounds").item(0).getTextContent() );
            int observation = Integer.parseInt( statsElement.getElementsByTagName("observation").item(0).getTextContent() );
            int bargain = Integer.parseInt( statsElement.getElementsByTagName("bargain").item(0).getTextContent() );
            int weaponModifier = Integer.parseInt( statsElement.getElementsByTagName("weaponModifier").item(0).getTextContent() );
            int armorModifier = Integer.parseInt( statsElement.getElementsByTagName("armorModifier").item(0).getTextContent() );

            Stats stats = new Stats();
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

            return stats;
        }
        catch (Exception e) {
            throw new LoadException(e);
        }

        //catch (ParserConfigurationException e) {
        //}

        //catch (SAXException e) {
        //}

        //catch (IOException e) {
        //}
    }
}
