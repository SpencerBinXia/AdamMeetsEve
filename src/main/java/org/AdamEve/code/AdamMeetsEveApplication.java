package org.AdamEve.code;

import org.AdamEve.controller.indexController;
import org.AdamEve.object.loginInfo;
import org.AdamEve.repository.userrepository;
import org.AdamEve.service.loginRegisterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses={AdamMeetsEveApplication.class, indexController.class,
		userrepository.class,loginRegisterService.class, loginInfo.class})
public class AdamMeetsEveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdamMeetsEveApplication.class, args);
	}
}
