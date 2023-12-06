package com.education.ztu;

import com.education.ztu.parsers.Pet;
import com.education.ztu.parsers.Pets;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static com.education.ztu.parsers.Json.*;
import static com.education.ztu.parsers.XML.*;
import static com.education.ztu.parsers.XMLPets.*;

public class Main {
    private static String currentDir = Paths.get("").toAbsolutePath().toString();

    public static void main(String[] args) {
        try {
            Document petsDoc = createXMLPet();
            saveXML(petsDoc, currentDir + "\\pets.xml");
            printXML(readXML(currentDir + "\\pets.xml", Pet.class));


            Pets pets = new Pets();
            pets.petList = new ArrayList<>();
            pets.petList.add(new Pet("1", "Kiwi", "3", "Vlada"));
            pets.petList.add(new Pet("2", "Freia", "5", "Andrii"));

            String json = JavaToJson(pets);
            System.out.println(json);
            pets = JsonToJava(json, Pets.class);
            System.out.println(pets.petList.toString());

        } catch (ParserConfigurationException | IOException | SAXException  e) {
            throw new RuntimeException(e);
        }

    }
}