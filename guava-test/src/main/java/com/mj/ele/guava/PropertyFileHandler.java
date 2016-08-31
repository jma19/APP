package com.mj.ele.guava;


import com.google.common.base.Supplier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by majun on 15/10/11.
 */
public class PropertyFileHandler {

    private static final Supplier<Properties> supplier = new Supplier<Properties>() {
        public Properties get() {
            return getProperitesInstance();
        }

        private Properties getProperitesInstance() {
            Properties properties = new Properties();
            try {
                System.out.println(System.getProperties().propertyNames());
                properties.load(new FileInputStream("src/config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties;
        }
    };

    public static int getInt(String key){
        return Integer.parseInt(supplier.get().getProperty(key));
    }

    public static String getString(String key){
        return supplier.get().getProperty(key);
    }

}
