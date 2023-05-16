package com.weslleyfornari.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weslleyfornari.workshopmongo.domain.User;
import com.weslleyfornari.workshopmongo.dto.UserDTO;
import com.weslleyfornari.workshopmongo.repository.UserRepository;
import com.weslleyfornari.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}    
    

	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User oldObj = findById(obj.getId());
		updateData(oldObj, obj);
		return repo.save(oldObj);
		}

	
	private void updateData(User oldObj, User obj) {
		oldObj.setName(obj.getName());
		oldObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
