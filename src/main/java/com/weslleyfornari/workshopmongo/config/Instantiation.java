package com.weslleyfornari.workshopmongo.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.weslleyfornari.workshopmongo.domain.Post;
import com.weslleyfornari.workshopmongo.domain.User;
import com.weslleyfornari.workshopmongo.dto.AuthorDTO;
import com.weslleyfornari.workshopmongo.repository.PostRepository;
import com.weslleyfornari.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired //INJECAO DE DEPENDENCIA AUTOMATICA DAS CLASSES COM O BANCO DE DADOS
	private UserRepository userRep;
	
	@Autowired
	private PostRepository postRep;
	

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRep.deleteAll();
		postRep.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRep.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"), "Bom dia", "Acordei fliz hoje!", new AuthorDTO(maria));
		
		postRep.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRep.save(maria);
	}

}
