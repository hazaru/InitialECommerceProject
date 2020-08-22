package br.com.hazaru.cartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class Cartoes2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cartoes2Application.class, args);
	}

}
