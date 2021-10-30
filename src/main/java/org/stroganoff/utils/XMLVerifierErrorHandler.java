package org.stroganoff.utils;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class XMLVerifierErrorHandler extends DefaultHandler {

    public static final String ERROR_LOG_FILE = "Caught error creating XMLVerifierErrorHandler log file, using default log file";
    private Logger logger = Logger.getLogger(XMLVerifierErrorHandler.class);

    public XMLVerifierErrorHandler(String logFileName, Logger defaultLogger) {
        try {
            logger.addAppender(new FileAppender(new SimpleLayout(), logFileName));
        } catch (IOException e) {
            logger = defaultLogger;
            logger.error(ERROR_LOG_FILE);
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        logger.warn(getLineAddress(e) + " - " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return "Line: " + e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
