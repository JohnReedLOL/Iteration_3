package Save;

import Save.StatsSaver;
import model.entity.stats.Stats;
import model.entity.stats.SmasherStats;
import Save.SaveException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SmasherStatsSaver extends StatsSaver {

    private static SmasherStatsSaver instance = null;

    public static SmasherStatsSaver getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new SmasherStatsSaver();
            return instance;
        }
    }

    private SmasherStatsSaver(){
        super();
    }
    public Element createElement(Document doc, SmasherStats stats) throws SaveException{

        Element baseStats = super.createElement(doc, stats);

        Element oneHanded = doc.createElement("oneHanded");
        String oneHandedStr = String.valueOf(stats.getOneHanded());
        oneHanded.appendChild( doc.createTextNode(oneHandedStr) );

        Element twoHanded = doc.createElement("twoHanded");
        String twoHandedStr = String.valueOf(stats.getTwoHanded());
        twoHanded.appendChild( doc.createTextNode(twoHandedStr) );

        Element brawl = doc.createElement("brawl");
        String brawlStr = String.valueOf(stats.getBrawl());
        brawl.appendChild(doc.createTextNode(brawlStr));

        baseStats.appendChild(oneHanded);
        baseStats.appendChild(twoHanded);
        baseStats.appendChild(brawl);

        return baseStats;
    }
}
