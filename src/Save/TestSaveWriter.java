package Save;

import model.entity.stats.Stats;
import model.entity.stats.SneakStats;
import Save.StatsSaver;
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
import Save.StatsSaver;

public class TestSaveWriter {

    public static void test() {
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
