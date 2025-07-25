package br.com.mkanton.walletsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WalletsapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletsapiApplication.class, args);
        System.out.println("WalletsapiApplication started");
    }

}
