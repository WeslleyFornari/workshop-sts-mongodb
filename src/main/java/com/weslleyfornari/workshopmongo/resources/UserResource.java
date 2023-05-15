package com.weslleyfornari.workshopmongo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weslleyfornari.workshopmongo.domain.User;
import com.weslleyfornari.workshopmongo.services.UserService;

@RestController //CLASSE RESPONSAVEL POR SOLUCITAÇÕESS HTTP://
@RequestMapping(value = "/users") // 8081:/USERS
public class UserResource {
	
	@Autowired
	private UserService serv;
	
	@GetMapping // ENDPOINT NO POSTMAN
	public ResponseEntity<List<User>> findAll(){
	
		List<User> lista = serv.findAll();
		return ResponseEntity.ok().body(lista);
		
		
		
	}
	
	
	
	

}
