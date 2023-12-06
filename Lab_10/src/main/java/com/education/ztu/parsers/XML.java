package com.education.ztu.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XML {
    public static void saveXML(Document doc, String path) {
        try (FileOutputStream output =
                     new FileOutputStream(path)) {

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(output);
            transformer.transform(source, result);

            System.out.println("XML saved to " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static List<Map<String, String>> readXML(String path, Class clazz)
            throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(path));
        doc.getDocumentElement().normalize();

        List<Map<String, String>> dataList = new ArrayList<>();

        NodeList list = doc.getElementsByTagName(clazz.getSimpleName().toLowerCase());
        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Map<String, String> map = new HashMap<>();
                map.put("elementName", node.getNodeName());
                Element element = (Element) node;
                for (Field field : clazz.getDeclaredFields()) {
                    String value = element.getElementsByTagName(field.getName().toLowerCase())
                            .item(0).getTextContent();
                    map.put(field.getName().toLowerCase(), value);
                }

                dataList.add(map);
            }
        }
        return dataList;
    }
}
