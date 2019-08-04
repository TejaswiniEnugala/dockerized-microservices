package com.stackroute.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import static org.springframework.boot.SpringApplication.*;

@EnableConfigServer
@SpringBootApplication
public class SpringConfigServerApplication {

    public static void main(String[] args) {
        run(SpringConfigServerApplication.class,args);
    }

}
