package org.stroganoff.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.exceptions.XmlFileException;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class XMLConverterTest {
    @InjectMocks
    XMLConverter xmlConverter;

    @Test
    void convertXMLToJSON() throws XmlFileException {
        //GIVEN
        String expectedString = "{\"test\":{\"name\":\"diamond\"}}";
        String xml = xmlConverter.xmlFileResourceToString("/test.xml");
        //WHEN
        String jsonString = xmlConverter.convertXMLToJSON(xml);
        //THEN
        Assertions.assertEquals(expectedString, jsonString);
    }

    @Test
    void xmlFileResourceToString_ReturnXMLString() throws XmlFileException {
        //GIVEN
        String expectedString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><test> <name>diamond</name> </test>";
        //WHEN
        String xml = xmlConverter.xmlFileResourceToString("/test.xml");
        //THEN
        Assertions.assertEquals(expectedString, xml);
    }
}