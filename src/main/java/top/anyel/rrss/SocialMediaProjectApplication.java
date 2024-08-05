package top.anyel.rrss;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.cloud.netflix.eureka.*;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "top.anyel.rrss.repository")


public class SocialMediaProjectApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        // Obtener la variable de entorno y establecerla en el sistema
        System.setProperty("SPRING_DATA_MONGODB_URI", dotenv.get("SPRING_DATA_MONGODB_URI"));
        SpringApplication.run(SocialMediaProjectApplication.class, args);
    }

}
