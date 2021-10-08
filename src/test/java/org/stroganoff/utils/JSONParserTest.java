package org.stroganoff.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JSONParserTest {


    @InjectMocks
    JSONParser jsonParser;


    @Test
    void getGemEntity() {
        //GIVEN
        String testString = "{\"test\":{\"name\":\"diamond\"}}";
        //WHEN
        jsonParser.getGemEntity();
        //THEN

    }
}