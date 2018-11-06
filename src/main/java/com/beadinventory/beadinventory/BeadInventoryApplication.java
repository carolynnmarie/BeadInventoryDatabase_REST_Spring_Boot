package com.beadinventory.beadinventory;


import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeadInventoryApplication {


    public static void main(String[] args) {
        SpringApplication.run(BeadInventoryApplication.class, args);
    }

}
