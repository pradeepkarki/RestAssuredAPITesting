package com.karki.reqres.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MavenProperties {

    private final Properties properties;

    public MavenProperties()  {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/resources" + "/maven.properties");
            properties.load(ip);
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static Properties getMavenProperties() {
        return SingletonHolder.getInstance().properties;
    }

    public static String getEnvironment()
    {
        return getMavenProperties().getProperty("env");
    }
    public static String getRetry()
    {
        return getMavenProperties().getProperty("retry");
    }


    private static class SingletonHolder {


        private static MavenProperties INSTANCE;


        private SingletonHolder() {
        }

        public static MavenProperties getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new MavenProperties();
            }
            return INSTANCE;
        }

    }

}
