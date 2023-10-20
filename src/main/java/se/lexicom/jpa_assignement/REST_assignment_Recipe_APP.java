package se.lexicom.jpa_assignement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication()
public class REST_assignment_Recipe_APP {

    public static void main(String[] args) {

        SpringApplication.run(REST_assignment_Recipe_APP.class, args);
    }

}
