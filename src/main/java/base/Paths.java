package base;

import java.io.File;

public class Paths {
    public static final String DEFAULT_DIR = System.getProperty("user.dir");
    public static String CLS_FARMING_PROPERTIES = DEFAULT_DIR + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "clsFarming.properties";
    public static String USER_PROPERTIES = DEFAULT_DIR + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + System.getProperty("propertyFileName");
//    to debug uncomment the following line and comment the above line
//    public static String USER_PROPERTIES = DEFAULT_DIR + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "ansuman.properties";
}
