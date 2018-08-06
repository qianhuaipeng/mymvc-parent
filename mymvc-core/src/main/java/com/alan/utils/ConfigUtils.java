package com.alan.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * author: alan.peng
 * description:
 * date: create in 16:30 2018/8/2
 * modified By：
 */
public class ConfigUtils {

    private static Properties properties = new Properties();

    static {
        List<File> files = FileUtils.findFiles(".properties");
        Properties prop = null;
        for(File file : files) {
            prop = new Properties();
            try {
                prop.load(new FileReader(file));
                properties.putAll(prop);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void init(){

    }

    public static Properties getProperties(){
        return properties;
    }

    public static boolean containsKey(String key){
        return properties.containsKey(key);
    }

    public static Properties getProperties(String nameSpace) {
        Properties prop = new Properties();
        String prefix = nameSpace + ".";
        for (String key : properties.stringPropertyNames()) {
            if (key.startsWith(prefix)) {
                prop.put(key.substring(prefix.length()), properties.get(key));
            }
        }
        return prop;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public static String getString(String key){
        if (properties.get(key) == null)
            return "";
        return properties.get(key).toString();
    }

    public static Boolean getBoolean(String key, Boolean defaultValue){
        String val = getString(key);
        return val == null || val.isEmpty() ? defaultValue : Boolean.valueOf(val);
    }
}
