package Save;

import Save.StatsSaver;
import model.entity.stats.Stats;
import model.entity.stats.SneakStats;
import Save.SaveException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SneakStatsSaver extends StatsSaver {

    private static SneakStatsSaver instance = null;

    public static SneakStatsSaver getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new SneakStatsSaver();
            return instance;
        }
    }

    private SneakStatsSaver(){
        super();
    }
    public Element createElement(Document doc, SneakStats stats) throws SaveException{

        Element baseStats = super.createElement(doc, stats);

        Element pickpocket = doc.createElement("pickpocket");
        String pickpocketStr = String.valueOf(stats.getPickpocket());
        pickpocket.appendChild( doc.createTextNode(pickpocketStr) );

        Element trapping = doc.createElement("trapping");
        String trappingStr = String.valueOf(stats.getTrapping());
        trapping.appendChild( doc.createTextNode(trappingStr) );

        Element creep = doc.createElement("creep");
        String creepStr = String.valueOf(stats.getCreep());
        creep.appendChild(doc.createTextNode(creepStr));

        Element rangedWeapon = doc.createElement("rangedWeapon");
        String rangedWeaponStr = String.valueOf(stats.getRangedWeapon());
        rangedWeapon.appendChild( doc.createTextNode(rangedWeaponStr) );

        baseStats.appendChild(pickpocket);
        baseStats.appendChild(trapping);
        baseStats.appendChild(creep);
        baseStats.appendChild(rangedWeapon);

        return baseStats;
    }
}

