package com.informatorio.proyectofinal;

import com.informatorio.proyectofinal.security.AppUser;
import com.informatorio.proyectofinal.security.LoggedInUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class ProyectoFinalApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	@GetMapping("/secured")
	public Object secured(@LoggedInUser AppUser appUser){
		return appUser.getUser();
	}

	@GetMapping("/secured-admin")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String securedAdmin(){
		return "Only admin can see this";
	}

	@GetMapping("/public")
	public String pub(){

		return "This is public endpoint";
	}

	@GetMapping("/what-is-the-time")
	String time(){
		return new Date().toString();
	}
}
