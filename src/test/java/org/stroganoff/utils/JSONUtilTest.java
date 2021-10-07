package org.stroganoff.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JSONUtilTest {

    @InjectMocks
    JSONUtil jsonUtil;

    @Test
    void jsonSaveToFile_Return_True() {
        //GIVEN
        String jsonString = "{\"test\":{\"name\":\"diamond\"}}";
        String fileToSaveJSON = "src/main/resources/JSONTestFile.json";
        jsonUtil.setJsonString(jsonString);
        //WHEN
        boolean actual = jsonUtil.jsonSaveToFile(fileToSaveJSON);
        //THEN
        Assertions.assertTrue(actual);
    }
}
