package org.stroganoff.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.stroganoff.entities.Gem;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public List<Gem> getGemList(String jsonString) {
        JsonElement jsonRootElement = JsonParser.parseString(jsonString);
        JsonObject rootObject = jsonRootElement.getAsJsonObject();
        JsonObject stones = rootObject.getAsJsonObject("stones");
        JsonArray gemArray = stones.getAsJsonArray("gem");
        List<Gem> gemList = new ArrayList<>();
        for (JsonElement jsonElement : gemArray) {
            gemList.add(getGemFromJsonElement(jsonElement));
        }
        return gemList;
    }

    public Gem getGemFromJsonElement(JsonElement jsonElement) {
        JsonObject currentJsonObject = jsonElement.getAsJsonObject();
        GemBuilder gemBuilder = new GemBuilder(currentJsonObject);
        return gemBuilder.buildGem();
    }
}
