package SdaFinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This is entry point for spring boot application.
 * Additional configuration for *war deployment is made with
 * SpringApplicationBuilder configuration method
 **/


@SpringBootApplication
public class SdaFinalProjectApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(SdaFinalProjectApplication.class, args);
    }

    /**
     * This method is used for war file build
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SdaFinalProjectApplication.class);
    }

}
