package Save;

import model.entity.stats.Stats;
import Save.SaveException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StatsSaver {

    private static StatsSaver instance = null;

    public static StatsSaver getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new StatsSaver();
            return instance;
        }
    }

    public StatsSaver() {}
    public Element createElement(Document doc, Stats stats) throws SaveException{
        Element statsElement = doc.createElement("stats");

        Element currentLife = doc.createElement("currentLife");
        String currentLifeStr = String.valueOf( stats.getCurrentLife() );
        currentLife.appendChild( doc.createTextNode(currentLifeStr) );

        Element currentMana = doc.createElement("currentMana");
        String currentManaStr = String.valueOf( stats.getCurrentMana() );
        currentMana.appendChild( doc.createTextNode(currentManaStr) );

        Element strength = doc.createElement("strength");
        String strengthStr = String.valueOf( stats.getStrength() );
        strength.appendChild( doc.createTextNode(strengthStr) );

        Element agility = doc.createElement("agility");
        String agilityStr = String.valueOf( stats.getAgility() );
        agility.appendChild( doc.createTextNode(agilityStr) );

        Element intellect = doc.createElement("intellect");
        String intellectStr = String.valueOf( stats.getIntellect() );
        intellect.appendChild( doc.createTextNode(intellectStr) );

        Element hardiness = doc.createElement("hardiness");
        String hardinessStr = String.valueOf( stats.getHardiness() );
        hardiness.appendChild( doc.createTextNode(hardinessStr) );

        Element experience = doc.createElement("experience");
        String experienceStr = String.valueOf( stats.getExperience() );
        experience.appendChild( doc.createTextNode(experienceStr) );

        Element movement = doc.createElement("movement");
        String movementStr = String.valueOf( stats.getMovement() );
        movement.appendChild( doc.createTextNode(movementStr) );

        Element bindWounds = doc.createElement("bindWounds");
        String bindWoundsStr = String.valueOf( stats.getBindWounds() );
        bindWounds.appendChild( doc.createTextNode(bindWoundsStr) );

        Element observation = doc.createElement("observation");
        String observationStr = String.valueOf( stats.getObservation() );
        observation.appendChild( doc.createTextNode(observationStr) );

        Element bargain = doc.createElement("bargain");
        String bargainStr = String.valueOf( stats.getBargain() );
        bargain.appendChild( doc.createTextNode(bargainStr) );

        Element weaponModifier = doc.createElement("weaponModifier");
        String weaponModifierStr = String.valueOf( stats.getWeaponModifier() );
        weaponModifier.appendChild( doc.createTextNode(weaponModifierStr) );

        Element armorModifier = doc.createElement("armorModifier");
        String armorModifierStr = String.valueOf( stats.getArmorModifier() );
        armorModifier.appendChild( doc.createTextNode(armorModifierStr) );

        statsElement.appendChild(currentLife);
        statsElement.appendChild(currentMana);
        statsElement.appendChild(strength);
        statsElement.appendChild(agility);
        statsElement.appendChild(intellect);
        statsElement.appendChild(hardiness);
        statsElement.appendChild(experience);
        statsElement.appendChild(movement);
        statsElement.appendChild(bindWounds);
        statsElement.appendChild(observation);
        statsElement.appendChild(bargain);
        statsElement.appendChild(weaponModifier);
        statsElement.appendChild(armorModifier);

        return statsElement;

    }

}

