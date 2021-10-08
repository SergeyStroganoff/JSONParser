package org.stroganoff.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtil {

    private final org.apache.log4j.Logger logger = Logger.getLogger(JSONUtil.class);

    public boolean jsonSaveToFile(String filePath, String jsonString) {
        try {
            Files.write(Paths.get(filePath), jsonString.getBytes());
        } catch (IOException e) {
            logger.error(e.getMessage() + filePath);
            return false;
        }
        return true;
    }

    public String readFileAsString(String filePath) throws IOException {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            logger.error(e.getMessage() + filePath);
            throw e;
        }
    }
}
