package br.com.apirest.opersms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="br.com.apirest.opersms")
public class OpersmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpersmsApplication.class, args);
	}

}
