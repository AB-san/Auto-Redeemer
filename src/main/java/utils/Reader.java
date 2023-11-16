package utils;

import base.Paths;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class Reader {
    static Properties props = new Properties();

    static {
        try {
            loadPropertyFile(Paths.USER_PROPERTIES);
            loadPropertyFile(Paths.CLS_FARMING_PROPERTIES);
        } catch (IOException realCause) {
            Assert.fail("Unable to load file!", realCause);
        }
    }

    public static void loadPropertyFile(String propertyFileName) throws IOException {
        log.info("Loading property file : " + propertyFileName);
        FileInputStream inStream = new FileInputStream(propertyFileName);
        props.load(inStream);
        inStream.close();
    }
    public static String getProperty(String propertyKey) {
        String propertyValue = props.getProperty(propertyKey.trim());
        if (propertyValue == null || propertyValue.trim().length() == 0) {
            log.info("Failed to read property with key : " + propertyKey);
        }
        return propertyValue;
    }
    public static void setProperty(String propertyKey, String value) {
        props.setProperty(propertyKey, value);
    }
}
