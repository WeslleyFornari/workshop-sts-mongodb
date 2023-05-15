package com.weslleyfornari.workshopmongo.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.weslleyfornari.workshopmongo.domain.User;
import com.weslleyfornari.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired //INJECAO DE DEPENDENCIA AUTOMATICA DE TODAS AS CLASSES
	private UserRepository userRep;
	

	@Override
	public void run(String... args) throws Exception {
		
		userRep.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRep.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
