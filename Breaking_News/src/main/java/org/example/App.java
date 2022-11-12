package org.example;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.io.*;
import java.net.URL;


/**
 * Hello world!
 *
 */
public class App
{
    private static final String XSLT_FILENAME
            = "src/main/resources/xml-html.xslt";
    private static String URL = "http://www.ynet.co.il/Integration/StoryRss2.xml";

    public static void main(String[] args) throws IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(URL);

            // transform xml to html via a xslt file
            try (FileOutputStream output =
                         new FileOutputStream("src/main/resources/HTML_File.html")) {
                transform(doc, output);
            }

        } catch (IOException | ParserConfigurationException |
                 SAXException | TransformerException e) {
            e.printStackTrace();
        }
        File myfile=new File("src/main/resources/HTML_File.html");
        Desktop.getDesktop().open(myfile);



    }

    private static void transform(Document doc, OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        // add XSLT in Transformer
        Transformer transformer = transformerFactory.newTransformer(
                new StreamSource(new File(XSLT_FILENAME)));

        transformer.transform(new DOMSource(doc), new StreamResult(output));

    }
}
