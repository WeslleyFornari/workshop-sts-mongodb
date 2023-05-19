package com.weslleyfornari.workshopmongo.resources;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weslleyfornari.workshopmongo.domain.Post;
import com.weslleyfornari.workshopmongo.resources.util.URL;
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
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "")String text){
			
		text = URL.decoderParam(text);
		List<Post> lista = serv.findByTitle(text);
		
		return ResponseEntity.ok().body(lista);
		}
	
	//@GetMapping(value = "/fullSearch") //OUTRA OPCAO
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decoderParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = serv.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
}
}
	
	
	
	


