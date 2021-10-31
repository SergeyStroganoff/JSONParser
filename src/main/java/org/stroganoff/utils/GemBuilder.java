package org.stroganoff.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.apache.log4j.Logger;
import org.stroganoff.entities.*;

import java.util.Arrays;

public class GemBuilder {

    private JsonObject currentJsonObject;
    private final Logger LOGGER = Logger.getLogger(GemBuilder.class);

    public GemBuilder(JsonObject currentJsonObject) {
        this.currentJsonObject = currentJsonObject;
    }

    public void setCurrentJsonObject(JsonObject currentJsonObject) {
        this.currentJsonObject = currentJsonObject;
    }

    public Gem buildGem() {
        Gem gemInstance = null;
        try {
            String name = currentJsonObject.getAsJsonPrimitive("name").getAsString();
            JsonPrimitive preciousnessPrimitive = currentJsonObject.getAsJsonPrimitive("preciousness");
            Preciousness preciousness = Preciousness.valueOf(preciousnessPrimitive.getAsString());
            JsonPrimitive miningLocationPrimitive = currentJsonObject.getAsJsonPrimitive("miningLocation");
            String miningLocation = miningLocationPrimitive.getAsString();
            JsonObject visualParametersJSONObject = currentJsonObject.getAsJsonObject("visualParameters");
            VisualParameters visualParameters = buildVisualParametersInstance(visualParametersJSONObject);
            JsonPrimitive stoneWeightPrimitive = currentJsonObject.getAsJsonPrimitive("stoneWeight");
            double stoneWeight = stoneWeightPrimitive.getAsDouble();
            gemInstance = new Gem(name, preciousness, miningLocation, visualParameters, stoneWeight);
        } catch (NullPointerException e) {
            LOGGER.error(e.toString());
            Arrays.stream(e.getStackTrace()).forEach(LOGGER::error);
        }

        return gemInstance;
    }

    public VisualParameters buildVisualParametersInstance(JsonObject visualParameters) {
        try {
            JsonPrimitive transparencyPrimitive = visualParameters.getAsJsonPrimitive("transparency");
            Transparency transparency = Transparency.valueOf(transparencyPrimitive.getAsString());
            JsonPrimitive colorPrimitive = visualParameters.getAsJsonPrimitive("color");
            Color color = Color.valueOf(colorPrimitive.getAsString());
            JsonPrimitive facesNumberPrimitive = visualParameters.getAsJsonPrimitive("facesNumber");
            int facesNumber = facesNumberPrimitive.getAsInt();
            return new VisualParameters(color, transparency, facesNumber);
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(LOGGER::error);
            return null;
        }
    }
}
