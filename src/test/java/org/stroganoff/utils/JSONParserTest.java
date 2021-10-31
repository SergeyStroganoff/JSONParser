package org.stroganoff.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.stroganoff.entities.Gem;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class JSONParserTest {

    @InjectMocks
    JSONParser jsonParser;

    String expectedGemName = "diamond";

    @Test
    void getGemList() {
        //GIVEN
        String testJSONString = "{\"stones\":{\"xmlns\":\"https://example.com/gem\",\"xsi:schemaLocation\":\"https://example.com/gem stones_schema.xsd\",\"xmlns:xsi\":\"http://www.w3.org/2001/XMLSchema-instance\",\"gem\":[{\"stoneWeight\":3.5,\"preciousness\":\"PRECIOUS\",\"miningLocation\":\"South Africa\",\"name\":\"diamond\",\"visualParameters\":{\"color\":\"BLUE\",\"facesNumber\":128,\"transparency\":\"CRYSTAL_CLEAR\"}}]}}";
        //WHEN
        List<Gem> gemList = jsonParser.getGemList(testJSONString);
        //THEN
        Assertions.assertNotNull(gemList);
        Assertions.assertEquals(expectedGemName, gemList.get(0).getName());

    }

    @Test
    void getGemFromJsonElement_ReturnGemObject() {
        //GIVEN
        String testString = "{\"stoneWeight\":3.5,\"preciousness\":\"PRECIOUS\",\"miningLocation\":\"South Africa\",\"name\":\"diamond\",\"visualParameters\":{\"color\":\"BLUE\",\"facesNumber\":128,\"transparency\":\"CRYSTAL_CLEAR\"}}";
        JsonElement element = JsonParser.parseString(testString);

        //WHEN
        Gem gem = jsonParser.getGemFromJsonElement(element);
        //THEN
        Assertions.assertNotNull(gem);
        Assertions.assertEquals(expectedGemName, gem.getName());
    }
}