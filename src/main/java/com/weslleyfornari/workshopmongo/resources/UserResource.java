package com.weslleyfornari.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.weslleyfornari.workshopmongo.domain.User;
import com.weslleyfornari.workshopmongo.dto.UserDTO;
import com.weslleyfornari.workshopmongo.services.UserService;

@RestController //CLASSE RESPONSAVEL POR SOLUCITAÇÕESS HTTP://
@RequestMapping(value = "/users") // 8081:/USERS
public class UserResource {
	
	@Autowired //INJEÇÃO AUTOMATICA DE DEPENDENCIA DA CLASSE
	private UserService serv;
	
	@GetMapping // ENDPOINT NO POSTMAN
	public ResponseEntity<List<UserDTO>> findAll(){
	
		List<User> lista = serv.findAll();
		List<UserDTO> listaDTO = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
		
	}		
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable String id){
			
			User obj = serv.findById(id);
			User listaIdDTO = obj;
			return ResponseEntity.ok().body(listaIdDTO);
		}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		
		User obj = serv.fromDTO(objDTO);
	    obj = serv.insert(obj);
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	}
	
	
	
	


