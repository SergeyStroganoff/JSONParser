package org.stroganoff.exceptions;

public class XmlFileException extends Exception {
    public XmlFileException(String message) {
        super(message);
    }

    public XmlFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
