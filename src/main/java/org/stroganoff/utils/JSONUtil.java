package org.stroganoff.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtil {

    private final org.apache.log4j.Logger logger = Logger.getLogger(JSONUtil.class);
    String jsonString;

    public JSONUtil(String jsonString) {
        this.jsonString = jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public boolean jsonSaveToFile(String filePath) {
        try {
            Files.write(Paths.get(filePath), jsonString.getBytes());
        } catch (IOException e) {
            logger.error(e.getMessage() + filePath);
            return false;
        }
        return true;
    }
}
