package com.ultrastyle.projet_ultra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjetUltraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetUltraApplication.class, args);
	}

}
