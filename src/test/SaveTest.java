package test;

import model.entity.stats.SneakStats;
import Save.SneakStatsSaver;
import Save.SaveException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SaveTest {

    public static void main(String[] args) {
        try {
            SneakStats stats = new SneakStats();
            SneakStatsSaver saver = SneakStatsSaver.getInstance();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element statsElement = saver.createElement(doc, stats);
            doc.appendChild(statsElement);

            Save.SaveWriter.saveDoc(doc, "test-stats.xml");

        } catch (SaveException e) {
            e.printStackTrace();
        }

        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
