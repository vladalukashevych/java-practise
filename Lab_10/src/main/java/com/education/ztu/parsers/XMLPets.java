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
import java.util.List;
import java.util.Map;

public class XMLPets {
    public static Document createXMLPet()
            throws ParserConfigurationException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element rootElement = doc.createElement("pets");
        doc.appendChild(rootElement);

        addPet(doc, rootElement, "1", "Kiwi", "3", "Vlada");
        addPet(doc, rootElement, "2", "Freia", "5", "Andrii");

        return doc;
    }

    public static void addPet(Document doc, Element root, String id, String name, String age, String owner) {
        Element pet = doc.createElement("pet");
        root.appendChild(pet);

        Element idElement = doc.createElement("id");
        idElement.appendChild(doc.createTextNode(id));
        pet.appendChild(idElement);

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        pet.appendChild(nameElement);

        Element ageElement = doc.createElement("age");
        ageElement.appendChild(doc.createTextNode(age));
        pet.appendChild(ageElement);

        Element ownerElement = doc.createElement("owner");
        ownerElement.appendChild(doc.createTextNode(owner));
        pet.appendChild(ownerElement);
    }

    public static void printXML(List<Map<String, String>> dataList) {
        System.out.println("Pets");
        for (Map<String, String> pet : dataList) {
            System.out.println("Element: " + pet.get("elementName"));
            System.out.println("\tId: " + pet.get("id"));
            System.out.println("\tName: " + pet.get("name"));
            System.out.println("\tAge: " + pet.get("age"));
            System.out.println("\tOwner: " + pet.get("owner"));
        }
    }
}
