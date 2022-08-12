package com.pouyankhodabakhsh.algorithm.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

public class Configuration {

    private static Configuration instance = null;

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getFilepath() throws IOException {
        Properties properties;
        try (InputStreamReader propFile = new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getResourceAsStream("/resources.properties")),
                StandardCharsets.UTF_8)) {
            properties = new Properties();
            properties.load(propFile);
        }
        return properties.getProperty("file.path");
    }
}
