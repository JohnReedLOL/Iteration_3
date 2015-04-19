package test;

import model.entity.stats.SummonerStats;
import model.entity.stats.Stats;
import Save.*;
import Load.*;
import Save.SaveException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.IOException;

public class SaveLoadTest {
    public static void main(String[] args) {

        try {
            SummonerStats stats = new SummonerStats();
            stats.setStaff(7);
            stats.setExperience(5);


            SummonerStatsSaver saver = SummonerStatsSaver.getInstance();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element statsElement = saver.createElement(doc, stats);
            doc.appendChild(statsElement);

            Save.SaveWriter.saveDoc(doc, "Summoner-Stats.xml");

            File fXmlFile = new File("Summoner-Stats.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc2 = dBuilder.parse(fXmlFile);

            NodeList nlist = doc2.getElementsByTagName("stats");

            Node statNode = nlist.item(0);
            if (statNode.getNodeType() == Node.ELEMENT_NODE) {
                Element statElement = (Element) statNode;
                SummonerStatsLoader statsLoader = SummonerStatsLoader.getInstance();
                SummonerStats stats2 = statsLoader.build(statElement);

                if (stats2.getStaff() == 7 && stats2.getExperience() == 5) {
                    System.out.println("SummonerStats load/save passed!");
                }
                else {
                   System.out.println("Not equal") ;
                }
            }
            else {
                System.out.println("BAD");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
