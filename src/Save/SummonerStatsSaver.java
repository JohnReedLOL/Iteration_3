package Save;

import Save.StatsSaver;
import model.entity.stats.Stats;
import model.entity.stats.SummonerStats;
import Save.SaveException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SummonerStatsSaver extends StatsSaver {

    private static SummonerStatsSaver instance = null;

    public static SummonerStatsSaver getInstance() {
        if(instance != null) {
            return instance;
        }
        else {
            instance = new SummonerStatsSaver();
            return instance;
        }
    }

    private SummonerStatsSaver(){
        super();
    }
    public Element createElement(Document doc, SummonerStats stats) throws SaveException{

        Element baseStats = super.createElement(doc, stats);

        Element bane = doc.createElement("bane");
        String baneStr = String.valueOf(stats.getBane());
        bane.appendChild( doc.createTextNode(baneStr) );

        Element boon = doc.createElement("boon");
        String boonStr = String.valueOf(stats.getBoon());
        boon.appendChild( doc.createTextNode(boonStr) );

        Element enchantment = doc.createElement("enchantment");
        String enchantmentStr = String.valueOf(stats.getEnchantment());
        enchantment.appendChild(doc.createTextNode(enchantmentStr));

        Element staff = doc.createElement("staff");
        String staffStr = String.valueOf(stats.getStaff());
        staff.appendChild( doc.createTextNode(staffStr) );

        baseStats.appendChild(bane);
        baseStats.appendChild(boon);
        baseStats.appendChild(enchantment);
        baseStats.appendChild(staff);

        return baseStats;
    }
}

