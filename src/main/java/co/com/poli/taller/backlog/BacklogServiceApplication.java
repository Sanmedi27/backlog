package co.com.poli.taller.backlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BacklogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BacklogServiceApplication.class, args);
    }

}
