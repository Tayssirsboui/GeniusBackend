package tn.esprit.projet4arcticback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing
@Async
@SpringBootApplication
@EnableAsync
public class Projet4ArcticBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(Projet4ArcticBackApplication.class, args);
	}


}
