package com.adp.module.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.adp.module.entities.User;
import com.adp.module.repository.RoleRepository;
import com.adp.module.repository.UserRepository;



@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository repo;

	@Autowired
    private RoleRepository roleRepository;
	
	public User save(User user) {		
		System.out.println("----------------------------------"+roleRepository.findAll());
		 // user.setRoles(new HashSet<>(Arrays.asList(new Role("Users"))));
		 // user.setRoles(new HashSet<>(roleRepository.findAll()));
//		 user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));
//		 
        return repo.save(user);	
	}

	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	public User get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public User getUserByName(String username) {
		return repo.findByUserName(username);
	}
	
//	public User update(String User) {
//		 return repo.saveAll(User);
//	}
	
	

	
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return user;
	}

	 public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user) {
	        User updateUser = repo.findById(id)
	                .orElseThrow();


	        updateUser.setuserName(user.getName());
	        updateUser.setuserName(user.getuserName());
	        updateUser.setpassword(user.getPassword());


	        repo.save(updateUser);

	        return ResponseEntity.ok(updateUser);
	    }
		
	


	

	
	

	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return get(id);
	}


	
	
}

