package org.stroganoff.utils;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class XMLVerifier implements XMLVerification {
    private final Logger logger = Logger.getLogger(XMLVerifier.class);
    private final String logFilename;

    public XMLVerifier(String logFilename) {
        this.logFilename = logFilename;
    }

    @Override
    public boolean verificationToXSD(String xmlFileName, String schemaFileName) {
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(schemaFileName));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLVerifierErrorHandler xmlVerifierErrorHandler = new XMLVerifierErrorHandler(logFilename, logger);
            saxParser.parse(xmlFileName, xmlVerifierErrorHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
}
