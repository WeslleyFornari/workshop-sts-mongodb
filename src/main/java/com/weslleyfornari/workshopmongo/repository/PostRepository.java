package com.weslleyfornari.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.weslleyfornari.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}

//IGNORE CASE - IGNORA LETRAS MAIUSCULAS OUJ MINUSCULAS NA PROCURA