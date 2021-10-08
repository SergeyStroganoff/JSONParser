package org.stroganoff.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class JSONUtilTest {

    @InjectMocks
    JSONUtil jsonUtil;

    @Test
    void jsonSaveToFile_Return_True() {
        //GIVEN
        String jsonString = "{\"test\":{\"name\":\"diamond\"}}";
        String fileToSaveJSON = "src/main/resources/JSONTestFile.json";
        //WHEN
        boolean actual = jsonUtil.jsonSaveToFile(fileToSaveJSON, jsonString);
        //THEN
        Assertions.assertTrue(actual);
    }

    @Test
    void readFileAsString_ReturnValidString() throws IOException {
        //GIVEN
        String jsonExpectingString = "{\"test\":{\"name\":\"diamond\"}}";
        String filePath = "src/test/resources/JSONTestFile.json";
        //WHEN
        String actual = jsonUtil.readFileAsString(filePath);
        //THEN
        Assertions.assertEquals(jsonExpectingString, actual);
    }


}
