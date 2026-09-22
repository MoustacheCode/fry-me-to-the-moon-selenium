package config;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static final String configFile = "config.properties";
    public static final Properties properties = new Properties();
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();


    public ConfigReader() {
    }

    public static String get(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && systemProperty.isBlank()) {
            return systemProperty;
        } else {
            String envKey = key.replace(".", "_").toUpperCase();
            String envValue = dotenv.get(envKey);
            return envValue != null && !envValue.isBlank() ? envValue : properties.getProperty(key);
        }
    }

    // Grabs the URL
    public static String baseUrl() {
        return get("base.url");
    }

    // Grabs target browser
    public static String browser() {
        return get("browser");
    }

    // Grabs the wait time string - 10 seconds in this case
    public static long explicitWait() {
        return Long.parseLong(get("explicit.wait.seconds"));
    }

    // Fetches the login credentials
    public static String standardUsername() {
        return get("standard.username");
    }

    public static String standardPassword() {
        return get("standard.password");
    }

    // Automatically runs once when the class loads: finds the 'config.properties' file inside your resources folder, reads its data into memory, and cleans up after itself
    static {
        try {
            try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (input == null) {
                    throw new RuntimeException("config.properties not found");
                }

                properties.load(input);
            }

        } catch (IOException var5) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }
}

