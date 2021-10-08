package org.stroganoff;

import org.apache.log4j.Logger;
import org.stroganoff.exceptions.XmlFileException;
import org.stroganoff.utils.JSONParser;
import org.stroganoff.utils.JSONUtil;
import org.stroganoff.utils.XMLConverter;

import java.io.IOException;

/**
 * JSON Parser.
 *
 * @author Sergey Stroganov
 */
public class App {

    public static final String FILE_PATH = "src/main/resources/stones.json";
    public static final String XML_FILE = "/stones.xml";
    public static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        XMLConverter xmlConverter = new XMLConverter();
        String xmlDataString = null;
        try {
            xmlDataString = xmlConverter.xmlFileResourceToString(XML_FILE);
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
