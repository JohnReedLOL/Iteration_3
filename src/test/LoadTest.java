package test;

import Load.StatsLoader;
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

public class LoadTest {

    public static void main(String[] args) {

        try {
            File fXmlFile = new File("test-stats.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            NodeList nlist = doc.getElementsByTagName("stats");

            Node statNode = nlist.item(0);
            if(statNode.getNodeType() == Node.ELEMENT_NODE) {
               Element statElement = (Element) statNode;
                StatsLoader statsLoader = StatsLoader.getInstance();
                Stats stats = statsLoader.build(statElement);
            }
        }

        catch (LoadException e) {
            e.printStackTrace();

        }
        catch(ParserConfigurationException e) {
            e.printStackTrace();
        }

        catch(org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

        catch(IOException e) {
            e.printStackTrace();
        }

    }
}
