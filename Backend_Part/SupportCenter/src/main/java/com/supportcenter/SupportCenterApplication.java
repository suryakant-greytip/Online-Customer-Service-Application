package com.supportcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class SupportCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportCenterApplication.class, args);
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

}
//
//{
//    "firstName": "Demo3",
//    "lastName": "Lastname3",
//    "email": "demo3@gmail.com",
//    "mobile": "2314574523",
//    "password": "12348",
//    "city": "BGp3"
//}