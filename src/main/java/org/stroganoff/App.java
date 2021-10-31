package org.stroganoff;

import org.apache.log4j.Logger;
import org.stroganoff.exceptions.XmlFileException;
import org.stroganoff.utils.*;

import java.io.IOException;
import java.nio.file.Path;

/**
 * JSON Parser.
 *
 * @author Sergey Stroganov
 */
public class App {

    public static final String FILE_PATH = "src/main/resources/stones.json";
    public static final String XML_FILE = "src/main/resources/stones.xml";
    public static final String XML_SCHEMA_FILE = "src/main/resources/stones_schema.xsd";
    public static final String VERIFIED_SUCCESSFUL = "XML file verified successful";
    public static final String NOT_VERIFIED = "XML file not verified, exit";
    public static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        XMLVerification xmlVerification = new XMLVerifier("xmlVerification.log");
        if (xmlVerification.verificationToXSD(XML_FILE, XML_SCHEMA_FILE)) {
            logger.info(XML_FILE + " - " + VERIFIED_SUCCESSFUL);
        } else {
            logger.error(NOT_VERIFIED);
            System.exit(1);
        }

        XMLConverter xmlConverter = new XMLConverter();
        String xmlDataString = null;
        try {
            xmlDataString = xmlConverter.xmlFileResourceToString("/stones.xml");
        } catch (XmlFileException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }

        String jsonString = xmlConverter.convertXMLToJSON(xmlDataString);
        JSONUtil jsonUtil = new JSONUtil();
        jsonUtil.jsonSaveToFile(FILE_PATH, jsonString);

        String jsonStonesString = null;
        try {
            jsonStonesString = jsonUtil.readFileAsString(FILE_PATH);
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }

        JSONParser jsonParser = new JSONParser();
        jsonParser.getGemList(jsonStonesString).forEach(System.out::println);
    }
}
