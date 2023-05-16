package com.weslleyfornari.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.weslleyfornari.workshopmongo.domain.Post;
import com.weslleyfornari.workshopmongo.domain.User;
import com.weslleyfornari.workshopmongo.dto.UserDTO;
import com.weslleyfornari.workshopmongo.services.PostService;

@RestController //CLASSE RESPONSAVEL POR SOLICITAÇÕESS HTTP://
@RequestMapping(value = "/posts") // 8081:/POSTS
public class PostResource {
	
	@Autowired //INJEÇÃO AUTOMATICA DE DEPENDENCIA DA CLASSE
	private PostService serv;
	
				
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
			
			Post obj = serv.findById(id);
			return ResponseEntity.ok().body(obj);
		}
	
}
	
	
	
	


