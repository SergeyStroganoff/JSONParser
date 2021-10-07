package org.stroganoff.utils;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.stroganoff.App;
import org.stroganoff.exceptions.XmlFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class XMLConverter {

    private final Logger logger = Logger.getLogger(XMLConverter.class);

    public String convertXMLToJSON(String xmlString) {
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
        return xmlJSONObj.toString();
    }

    public String xmlFileResourceToString(String xmlFileResource) throws XmlFileException {
        InputStream inputStream = App.class.getResourceAsStream(xmlFileResource);
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder stringBuilder = new StringBuilder();
                while (bufferedReader.ready()) {
                    stringBuilder.append(bufferedReader.readLine());
                }
                return stringBuilder.toString();
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new XmlFileException(e.getMessage());
            }
        } else {
            logger.error("File " + xmlFileResource + "was not found");
            throw new XmlFileException("File " + xmlFileResource + "was not found");
        }
    }
}

