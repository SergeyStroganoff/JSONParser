package org.stroganoff.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParser {

    public void getGemEntity() {
        JsonElement jsonElement = JsonParser.parseString("{\"message\":\"Hi\",\"place\":{\"name\":\"World!\"}}");
        JsonObject rootObject = jsonElement.getAsJsonObject();
        String message = rootObject.get("message").getAsString(); // get property "message"
        JsonObject childObject = rootObject.getAsJsonObject("place"); // get place object
        String place = childObject.get("name").getAsString(); // get property "name"
        System.out.println(message + " " + place); // print "Hi World!"*/

    }
}
