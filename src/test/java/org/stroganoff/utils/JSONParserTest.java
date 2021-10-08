package org.stroganoff.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JSONParserTest {


    @InjectMocks
    JSONParser jsonParser;


    @Test
    void getGemList() {
    }

    @Test
    void getGemFromJsonElement() {
        //GIVEN
        String testString = "{\"gem\":{\"stoneWeight\":3.5,\"preciousness\":\"PRECIOUS\",\"miningLocation\":\"South Africa\",\"name\":\"diamond\",\"visualParameters\":{\"color\":\"BLUE\",\"facesNumber\":128,\"transparency\":\"CRYSTAL_CLEAR\"}}}";
        JsonElement element = JsonParser.parseString(testString);
        //WHEN
        jsonParser.getGemFromJsonElement(element);
        //THEN
    }
}