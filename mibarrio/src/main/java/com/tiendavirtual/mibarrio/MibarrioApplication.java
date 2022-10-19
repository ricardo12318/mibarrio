package com.tiendavirtual.mibarrio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class MibarrioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MibarrioApplication.class, args);
	}
        /*@RequestMapping(value="/hola")
        public String index(){
            return "hola Santi como estas..";
        }*/
}
