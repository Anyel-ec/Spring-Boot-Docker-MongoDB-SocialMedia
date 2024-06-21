package top.anyel.rrss.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class AppEnvironment {

    private final Dotenv dotenv;

    public AppEnvironment() {
        this.dotenv = Dotenv.configure().load();
    }

    public String getProperty(String key) {
        return dotenv.get(key);
    }

    public String getBaseUrl() {
        return dotenv.get("BASE_URL");
    }

    public String getApiUserPath() {
        return dotenv.get("API_USER");
    }

    public static void main(String[] args) {
        AppEnvironment appEnvironment = new AppEnvironment();
        System.out.println(appEnvironment.getBaseUrl());
        System.out.println(appEnvironment.getApiUserPath());
    }
}