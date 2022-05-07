package KibanaProject.controller;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
class KibanaController {

    @Autowired
    RestTemplate restTemplete;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/elk")
    public String helloWorld() {
        String response = "Welcome to JavaInUse" + new Date();
        log.info(response);

        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured....");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            log.error("Exception - " + stackTrace);
            response = stackTrace;
        }

        return response;
    }
}