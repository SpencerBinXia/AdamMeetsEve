package org.AdamEve.AdamMeetsEve;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan ({"org.AdamEve.controller", "org.AdamEve.object", "org.AdamEve.repository", "org.AdamEve.service"})
public class AdamMeetsEveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdamMeetsEveApplication.class, args);
	}
}
